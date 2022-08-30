package dev.lightdream.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public interface LoggableMain {

    default String logFilesFolder() {
        return "/logs/";
    }

    boolean debug();

    default boolean logTime() {
        return false;
    }

    default boolean logToFile() {
        return false;
    }

    default void log(String log) {
        if (logTime()) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
            log = "[" + dtf.format(LocalDateTime.now()) + "] " + log;
        }

        System.out.println(log);

        if (logToFile()) {
            for (ConsoleColors value : ConsoleColors.values()) {
                log = log.replace(value.toString(), "");
            }

            Utils.writeToLog(log, this);
        }
    }


}