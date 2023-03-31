package elite.sas.workflows;

import elite.sas.activities.definition.RegistrationActivity;
import elite.sas.api.params.CreateStudentParams;
import elite.sas.api.params.CreateUserParams;
import elite.sas.entities.*;
import elite.sas.util.TemporalUtil;
import elite.sas.workflows.definition.RegisterStudentWorkflow;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

@Slf4j
public class RegisterStudentWorkflowImpl implements RegisterStudentWorkflow {

    private final RegistrationActivity registrationActivity = TemporalUtil.registrationActivitiesStub();

    @Override
    public Optional<Student> handle(CreateStudentParams params) {
        // register user

        var studentRole = Role.builder().roleName(RoleName.STUDENT).build();
        var roles = List.of(studentRole);

        var userParams = CreateUserParams.builder()
                .tenantId(params.getTenantId())
                .firstName(params.getFirstName())
                .lastName(params.getLastName())
                .userName(params.getUserName())
                .email(params.getEmail())
                .password(params.getPassword())
                .passwordConfirm(params.getPasswordConfirm())
                .roles(roles)
                .userType(UserType.STUDENT)
                .build();

        Optional<AppUser> optionalAppUser = registrationActivity.createUserAccount(userParams);

        if (optionalAppUser.isEmpty()) {
            return Optional.empty();
        }

        // create student
        AppUser appUser = optionalAppUser.get();

        params.setUserId(appUser.getId());

        return registrationActivity.registerStudent(params);
    }
}
