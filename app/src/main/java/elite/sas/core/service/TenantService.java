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
        return tenantRepository.findById(UUID.fromString(id));
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

    @Transactional
    public Tenant createTenant(CreateTenantParams createTenantParams) {
        return TemporalUtil.tenantRegistrationWorkflow().handle(createTenantParams);
    }
}
