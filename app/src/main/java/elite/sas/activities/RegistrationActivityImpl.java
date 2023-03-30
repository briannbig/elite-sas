package elite.sas.activities;

import elite.sas.activities.definition.RegistrationActivity;
import elite.sas.api.params.CreateStudentParams;
import elite.sas.api.params.CreateTenantParams;
import elite.sas.api.params.CreateUserParams;
import elite.sas.entities.*;
import elite.sas.repository.TenantRepository;
import elite.sas.service.AppUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.Optional;


@RequiredArgsConstructor
@Slf4j
public class RegistrationActivityImpl implements RegistrationActivity {

    private final AppUserService userService;
    private final TenantRepository tenantRepository;


    @Override
    public Optional<Tenant> registerTenant(CreateTenantParams createTenantParams) {
        return registerNewTenant(createTenantParams);
    }

    @Override
    public Optional<AppUser> createUserAccount(CreateUserParams createUserParams) {
        Optional<Account> optionalAccount = userService.registerNewUserAccount(createUserParams);
        return optionalAccount.map(Account::getAppUser);
    }


    @Override
    public Student registerStudent(CreateStudentParams createStudentParams) {
        return null;
    }

    @Override
    public AppUser registerSupervisor(CreateUserParams createUserParams) {
        return null;
    }

    @Override
    public AppUser registerAdmin(CreateUserParams createUserParams) {
        return null;
    }


    private Optional<Tenant> registerNewTenant(CreateTenantParams params) {

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
