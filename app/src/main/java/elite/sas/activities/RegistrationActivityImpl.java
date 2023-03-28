package elite.sas.activities;

import elite.sas.activities.definition.RegistrationActivity;
import elite.sas.api.params.CreateStudentParams;
import elite.sas.api.params.CreateTenantParams;
import elite.sas.api.params.CreateUserParams;
import elite.sas.entities.Account;
import elite.sas.entities.AppUser;
import elite.sas.entities.Student;
import elite.sas.entities.Tenant;
import elite.sas.service.AppUserService;
import elite.sas.service.TenantService;
import lombok.RequiredArgsConstructor;

import java.util.Optional;


@RequiredArgsConstructor
public class RegistrationActivityImpl implements RegistrationActivity {

    private final AppUserService userService;
    private final TenantService tenantService;


    @Override
    public Optional<Tenant> registerTenant(CreateTenantParams createTenantParams) {
        return tenantService.registerNewTenant(createTenantParams);
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
}
