package dev.lightdream.logger;

import lombok.SneakyThrows;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {

    @SneakyThrows
    public static void writeToLog(String log, LoggableMain main) {
        File dir = new File(System.getProperty("user.dir") + main.logFilesFolder());
        // noinspection ResultOfMethodCallIgnored
        dir.mkdirs();

        // File
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        File file = new File(dir, dtf.format(LocalDateTime.now()) + ".log");

        FileWriter fileWriter = new FileWriter(file, true);
        fileWriter.append(log)
                .append("\n");
        fileWriter.flush();
        fileWriter.close();
    }

}
