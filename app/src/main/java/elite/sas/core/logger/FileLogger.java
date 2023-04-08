package elite.sas.core.logger;

import elite.sas.core.entities.Log;

import java.io.FileWriter;
import java.io.IOException;

public class FileLogger {

    private static final String FILENAME = "logs.txt";
    private static FileLogger INSTANCE = null;

    private FileLogger() {

    }
    public static FileLogger getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new FileLogger();

        }
        return INSTANCE;
    }

    public void log(Log log) {
        try {
            FileWriter fileWriter = new FileWriter(FILENAME, true);
            fileWriter.write("\n" + log.toString());
            fileWriter.close();
            System.out.println("=====> Successfully logged " + log);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
