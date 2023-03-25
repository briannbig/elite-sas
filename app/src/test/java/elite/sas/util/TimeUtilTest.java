package elite.sas.util;

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