package elite.sas.util;

import elite.sas.core.util.TimeUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeUtilTest {

    @Test
    void testToString() {
    }

    @Test
    void getNextMonday() {
        System.out.println(TimeUtil.getNextMonday().getDayOfMonth());
    }
}