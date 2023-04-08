package elite.sas.core.activities.definition;

import elite.sas.core.entities.AppUser;
import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

import java.util.Map;

@ActivityInterface
public interface NotificationsActivity {

    @ActivityMethod
    void sendNotification(AppUser appUser, Map<String, String> data);

    @ActivityMethod
    void sendConfirmationEmail(AppUser appUser);
}
