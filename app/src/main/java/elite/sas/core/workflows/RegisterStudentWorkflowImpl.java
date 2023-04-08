package elite.sas.core.workflows;

import elite.sas.core.activities.definition.RegistrationActivity;
import elite.sas.core.api.params.CreateStudentParams;
import elite.sas.core.api.params.CreateUserParams;
import elite.sas.core.entities.*;
import elite.sas.core.util.TemporalUtil;
import elite.sas.core.workflows.definition.RegisterStudentWorkflow;
import elite.sas.core.workflows.definition.WorkflowStatus;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

@Slf4j
public class RegisterStudentWorkflowImpl implements RegisterStudentWorkflow {

    private final RegistrationActivity registrationActivity = TemporalUtil.registrationActivitiesStub();

    private WorkflowStatus status = WorkflowStatus.STARTED;

    @Override
    public WorkflowStatus getStatus() {
        return status;
    }

    @Override
    public Optional<Student> handle(CreateStudentParams params) {

        status = WorkflowStatus.EXECUTING;

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
            status = WorkflowStatus.FAILED;
            return Optional.empty();
        }

        // create student
        AppUser appUser = optionalAppUser.get();

        params.setUserId(appUser.getId());

        var optionalStudent = registrationActivity.registerStudent(params);

        if (optionalStudent.isEmpty()){
            status = WorkflowStatus.FAILED;
            return optionalStudent;
        }

        status = WorkflowStatus.SUCCESSFUL;
        return optionalStudent;


    }
}
