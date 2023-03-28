package elite.sas.activities;

import elite.sas.activities.definition.NotificationsActivity;
import elite.sas.entities.AppUser;
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
