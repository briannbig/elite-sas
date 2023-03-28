package elite.sas.workflows;

import elite.sas.util.TemporalUtil;
import elite.sas.activities.definition.NotificationsActivity;
import elite.sas.activities.definition.RegistrationActivity;
import elite.sas.api.params.CreateUserParams;
import elite.sas.entities.AppUser;
import elite.sas.workflows.definition.UserAccountRegistrationWorkflow;

import java.util.HashMap;
import java.util.Map;


public class UserAccountRegistrationWorkflowImpl implements UserAccountRegistrationWorkflow {

    private final RegistrationActivity registrationActivity = TemporalUtil.registrationActivitiesStub();
    private final NotificationsActivity notificationsActivity = TemporalUtil.notificationsActivityStub();
    @Override
    public AppUser handle(CreateUserParams createUserParams) {
        var user = registrationActivity.createUserAccount(createUserParams);
        user.ifPresent(value -> {
            Map<String, String> data = new HashMap<>();
            data.put("title", "User creation Successful!");
            notificationsActivity.sendNotification(value, data);
        });
        return user.orElse(null);
    }
}
