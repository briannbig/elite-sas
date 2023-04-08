package elite.sas.core.workflows;

import elite.sas.core.entities.AppUser;
import elite.sas.core.util.TemporalUtil;
import elite.sas.core.activities.definition.NotificationsActivity;
import elite.sas.core.activities.definition.RegistrationActivity;
import elite.sas.core.api.params.CreateUserParams;
import elite.sas.core.workflows.definition.UserAccountRegistrationWorkflow;
import elite.sas.core.workflows.definition.WorkflowStatus;

import java.util.HashMap;
import java.util.Map;


public class UserAccountRegistrationWorkflowImpl implements UserAccountRegistrationWorkflow {

    private final RegistrationActivity registrationActivity = TemporalUtil.registrationActivitiesStub();
    private final NotificationsActivity notificationsActivity = TemporalUtil.notificationsActivityStub();

    private WorkflowStatus status = WorkflowStatus.STARTED;

    @Override
    public WorkflowStatus getStatus() {
        return status;
    }

    @Override
    public AppUser handle(CreateUserParams createUserParams) {

        status = WorkflowStatus.EXECUTING;
        var user = registrationActivity.createUserAccount(createUserParams);
        user.ifPresent(value -> {
            status = WorkflowStatus.SUCCESSFUL;
            Map<String, String> data = new HashMap<>();
            data.put("title", "User creation Successful!");
            notificationsActivity.sendNotification(value, data);
        });
        if (user.isEmpty()) {
            status = WorkflowStatus.FAILED;
            return null;
        }

        return user.get();
    }
}
