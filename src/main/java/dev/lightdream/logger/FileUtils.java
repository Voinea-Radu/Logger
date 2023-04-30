package dev.lightdream.logger;

import lombok.SneakyThrows;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileUtils {

    @SneakyThrows
    public static void writeToFile(String log, String folder) {
        if(!folder.startsWith("/")){
            folder = "/" + folder;
        }
        File dir = new File(System.getProperty("user.dir") + folder);
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
