package elite.sas.core.activities.definition;

import elite.sas.core.api.params.CreateStudentParams;
import elite.sas.core.api.params.CreateTenantParams;
import elite.sas.core.api.params.CreateUserParams;
import elite.sas.core.entities.AppUser;
import elite.sas.core.entities.Student;
import elite.sas.core.entities.Tenant;
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
    Optional<Student> registerStudent(CreateStudentParams createStudentParams);

    @ActivityMethod
    AppUser registerSupervisor(CreateUserParams createUserParams);

    @ActivityMethod
    AppUser registerAdmin(CreateUserParams createUserParams);


}
