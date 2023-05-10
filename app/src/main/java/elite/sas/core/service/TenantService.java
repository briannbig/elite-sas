package elite.sas.core.service;

import elite.sas.core.api.params.CreateTenantParams;
import elite.sas.core.entities.AppUser;
import elite.sas.core.entities.Tenant;
import elite.sas.core.entities.UserType;
import elite.sas.core.repository.TenantRepository;
import elite.sas.core.util.TemporalUtil;
import elite.sas.core.entities.TenantType;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class TenantService {

    @Autowired
    private final TenantRepository tenantRepository;

    public Optional<Tenant> findTenantById(String id) {
        try {
            return tenantRepository.findById(UUID.fromString(id));
        } catch (Exception e) {
            log.debug("{}", e);
            return Optional.empty();
        }
    }

    public List<Tenant> getAllTenants() {
        return tenantRepository.findAll();
    }

    public List<Tenant> getAllSchools() {
        return tenantRepository.findByTenantType(TenantType.SCHOOL);
    }

    public List<Tenant> getAllCompanies() {
        return tenantRepository.findByTenantType(TenantType.COMPANY);
    }

    public List<Tenant> getAllTenantsByType(TenantType tenantType) {
        return tenantRepository.findByTenantType(tenantType);
    }

    public List<Tenant> getAllTenantsByLocation(String location) {
        return tenantRepository.findByLocation(location);
    }

    public Optional<Tenant> getInternalTenant() {
        return tenantRepository.findByTenantType(TenantType.INTERNAL)
                .stream().findFirst();
    }

    public List<AppUser> getTenantSupervisors(String id) {
        var optionalTenant = tenantRepository.findById(UUID.fromString(id));
        return optionalTenant.map(tenant ->
                tenant.getUsers().stream().
                        filter(u -> u.getUserType() == UserType.SUPERVISOR)
                        .collect(Collectors.toList())).orElseGet(ArrayList::new);
    }

    public List<AppUser> getSchoolStudents(String id) {
        var optionalTenant = tenantRepository.findById(UUID.fromString(id));
        return optionalTenant.map(tenant ->
                tenant.getUsers().stream().
                        filter(u -> u.getUserType() == UserType.STUDENT)
                        .collect(Collectors.toList())).orElseGet(ArrayList::new);
    }

    public List<AppUser> getAllUsersForTenant(String id) {
        try {
            var optionalTenant = tenantRepository.findById(UUID.fromString(id));
            return optionalTenant.get().getUsers();
        } catch (Exception e) {
            log.debug("{}", e);
            return List.of();
        }

    }

    @Transactional
    public Optional<Tenant> createTenant(CreateTenantParams createTenantParams) {
        return Optional.ofNullable(TemporalUtil.tenantRegistrationWorkflow().handle(createTenantParams));
    }


    public Optional<Tenant> updateTenant(Tenant tenant) {
        var optionalTenant = tenantRepository.findById(tenant.getId());
        if (optionalTenant.isEmpty()) {
            log.debug("tenant with id {} not found", tenant.getId());
            return Optional.empty();
        }

        if (!Objects.equals(optionalTenant.get().getName(), tenant.getName())) {
            optionalTenant.get().setName(tenant.getName());
        }

        if (!Objects.equals(optionalTenant.get().getLocation(), tenant.getLocation())) {
            optionalTenant.get().setLocation(tenant.getLocation());
        }

        if (!Objects.equals(optionalTenant.get().getTelephone(), tenant.getTelephone())) {
            var optionalTenantByTelephone = tenantRepository.findByTelephone(tenant.getTelephone());
            if (optionalTenantByTelephone.isEmpty()) {
                optionalTenant.get().setTelephone(tenant.getTelephone());
            } else {
                log.debug("telephone {} already taken", tenant.getTelephone());
                return Optional.empty();
            }

        }

        return Optional.of(tenantRepository.save(optionalTenant.get()));
    }
}
