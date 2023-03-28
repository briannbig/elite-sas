package elite.sas.activities.definition;

import elite.sas.api.params.CreateStudentParams;
import elite.sas.api.params.CreateTenantParams;
import elite.sas.api.params.CreateUserParams;
import elite.sas.entities.AppUser;
import elite.sas.entities.Student;
import elite.sas.entities.Tenant;
import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

import java.util.Optional;

@ActivityInterface
public interface RegistrationActivity {
    @ActivityMethod
    Optional<Tenant> registerTenant(CreateTenantParams createTenantParams);


    @ActivityMethod
    Optional<AppUser> createUserAccount(CreateUserParams createUserParams);

    @ActivityMethod
    Student registerStudent(CreateStudentParams createStudentParams);

    @ActivityMethod
    AppUser registerSupervisor(CreateUserParams createUserParams);

    @ActivityMethod
    AppUser registerAdmin(CreateUserParams createUserParams);


}
