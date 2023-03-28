package elite.sas.workflows;

import elite.sas.api.params.CreateUserParams;
import elite.sas.config.temporal.TemporalConfig;
import elite.sas.entities.AppUser;
import elite.sas.workflows.definition.UserAccountRegistrationWorkflow;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
@RequiredArgsConstructor
public class UserAccountRegistrationWorkflowImpl implements UserAccountRegistrationWorkflow {

    @Autowired
    private final TemporalConfig pool;


    @Override
    public AppUser handle(CreateUserParams createUserParams) {
        var user = pool.registrationActivity().createUserAccount(createUserParams);
        user.ifPresent(value -> {
            Map<String, String> data = new HashMap<>();
            data.put("title", "User creation Successful!");
            pool.notificationsActivity().sendNotification(value, data);
        });
        return user.orElse(null);
    }
}
