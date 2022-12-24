package dev.lightdream.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public interface LoggableMain {


    /**
     * The folder where the log files will be stored
     *
     * @return Relative path to the folder
     */
    default String logFilesFolder() {
        return "/logs/";
    }

    /**
     * The folder where the debug files will be stored
     *
     * @return Relative path to the folder
     */
    default String debugFilesFolder() {
        return "/debug/";
    }

    /**
     * Allows you to append the current time to every entry. Applies to logs from both {@link Logger} and {@link Debugger}
     *
     * @return true if you want to append the time to every entry
     */
    default boolean logTime() {
        return true;
    }

    /**
     * Allows you to log every action by {@link Logger} to a file specified in {@link LoggableMain#logFilesFolder}
     *
     * @return true if you want to log to file
     */
    default boolean logToFile() {
        return true;
    }

    /**
     * Allows you to log every action by {@link Debugger} to a file specified in {@link LoggableMain#debugFilesFolder}
     *
     * @return true if you want to log to file
     */
    default boolean debugToFile() {
        return true;
    }

    /**
     * Allows you to enable or disable the entries in console by {@link Debugger}
     *
     * @return true if you want to log to console
     */
    boolean debugToConsole();

    default void log(String log, boolean debug) {
        if (logTime()) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
            log = "[" + dtf.format(LocalDateTime.now()) + "] " + log;
        }

        if (logToFile() && !debug) {
            FileUtils.writeToLFile(ConsoleColors.clearString(log), logFilesFolder());
        }

        if (debugToFile() && debug) {
            FileUtils.writeToLFile(ConsoleColors.clearString(log), debugFilesFolder());
        }

        if(!debug) {
            logToConsole(log);
            return;
        }

        if(debugToConsole()) {
            logToConsole(log);
        }
    }

    /**
     * Prints the log to the console
     *
     * @param log The entry
     */
    default void logToConsole(String log) {
        System.out.println(log);
    }


}