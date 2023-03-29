package elite.sas.service;

import elite.sas.api.params.CreateTenantParams;
import elite.sas.entities.AppUser;
import elite.sas.entities.Tenant;
import elite.sas.entities.TenantType;
import elite.sas.entities.UserType;
import elite.sas.repository.TenantRepository;
import elite.sas.util.TemporalUtil;
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

    public Optional<Tenant> registerNewTenant(CreateTenantParams params) {

        if (Objects.isNull(params.getName()) ||
                Objects.isNull(params.getEmail()) ||
                Objects.isNull(params.getTelephone()) ||
                Objects.isNull(params.getLocation())
        ) {
            log.error("Missing required field(s) in the request");
            return Optional.empty();
        }

        Optional<Tenant> optionalTenantWithName = tenantRepository.findByName(params.getName());
        if (optionalTenantWithName.isPresent()) {
            log.debug("tenant with name '{}' already exists!", params.getName());
        }

        Optional<Tenant> optionalTenantWithEmail = tenantRepository.findByEmail(params.getEmail());
        if (optionalTenantWithEmail.isPresent()) {
            log.debug("tenant with email '{}' already exists!", params.getEmail());
        }

        Optional<Tenant> optionalTenantWithTelephone = tenantRepository.findByTelephone(params.getTelephone());
        if (optionalTenantWithTelephone.isPresent()) {
            log.debug("tenant with telephone '{}' already exists!", params.getTelephone());
        }

        TenantType tenantType = null;
        if (Objects.nonNull(params.getTenantType())) {
            tenantType = params.getTenantType();
        }

        var tenantBuilder = Tenant.builder()
                .name(params.getName())
                .email(params.getEmail())
                .telephone(params.getTelephone())
                .location(params.getLocation())
                .location(params.getLocation())
                .tenantType(tenantType);

        var tenant = tenantRepository.save(tenantBuilder.build());

        log.info("Tenant created successfully! {}", tenant);

        return Optional.of(tenant);

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

    @Transactional
    public Tenant createTenant(CreateTenantParams createTenantParams) {
        return TemporalUtil.tenantRegistrationWorkflow().handle(createTenantParams);
    }
}
