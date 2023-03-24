package elite.sas.util;

import java.util.concurrent.TimeUnit;

public final class TimeUtil {

    public static String toString(Long timeInMillis) {
        var hour = TimeUnit.MILLISECONDS.toHours(timeInMillis);
        var min = TimeUnit.MILLISECONDS.toMinutes(timeInMillis) - TimeUnit.MILLISECONDS.toMinutes(hour);
        var sec = TimeUnit.MILLISECONDS.toSeconds(timeInMillis) - TimeUnit.MILLISECONDS.toSeconds(hour) - TimeUnit.MILLISECONDS.toSeconds(min);

        return hour + ":" + min + ":" + sec;

    }
}
