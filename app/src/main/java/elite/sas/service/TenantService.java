package elite.sas.service;

import elite.sas.api.params.CreateTenantParams;
import elite.sas.entities.Tenant;
import elite.sas.entities.TenantType;
import elite.sas.repository.TenantRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TenantService {

    @Autowired
    private final TenantRepository tenantRepository;

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


}
