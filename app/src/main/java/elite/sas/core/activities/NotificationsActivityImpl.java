package elite.sas.core.activities;

import elite.sas.core.activities.definition.NotificationsActivity;
import elite.sas.core.entities.AppUser;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
@NoArgsConstructor
public class NotificationsActivityImpl implements NotificationsActivity {
    @Override
    public void sendNotification(AppUser appUser, Map<String, String> data) {
        log.debug("sending notification to {}, data: {}", appUser.getEmail(), data);
    }

    @Override
    public void sendConfirmationEmail(AppUser appUser) {
        log.debug("sending confirmation email for {} to {}", appUser.getUserName(), appUser.getEmail());
    }
}
