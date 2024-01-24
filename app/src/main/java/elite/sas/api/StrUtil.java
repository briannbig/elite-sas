package elite.sas.api;

public final class StrUtil {

    public static boolean areStrEmpty(String... strings) {
        boolean empty = false;

        for (String s : strings) {
            empty = s.isEmpty() || s.isBlank();
            if (empty) {
                return true;
            }
        }
        return empty;
    }
}
