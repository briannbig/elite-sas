package elite.sas.core.util;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public final class TimeUtil {

    public static String toString(Long timeInMillis) {
        var hour = TimeUnit.MILLISECONDS.toHours(timeInMillis);
        var min = TimeUnit.MILLISECONDS.toMinutes(timeInMillis) - TimeUnit.MILLISECONDS.toMinutes(hour);
        var sec = TimeUnit.MILLISECONDS.toSeconds(timeInMillis) - TimeUnit.MILLISECONDS.toSeconds(hour) - TimeUnit.MILLISECONDS.toSeconds(min);

        return hour + ":" + min + ":" + sec;

    }
    public static LocalDateTime getNextMonday() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nextMonday = now.with(DayOfWeek.MONDAY);
        if (nextMonday.isBefore(now)) {
            nextMonday = nextMonday.plusWeeks(1);
        }
        return nextMonday;
    }
}
