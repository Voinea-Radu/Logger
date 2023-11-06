package dev.lightdream.logger;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Printer {

    private static @Getter Printer.Settings settings;
    private final boolean debugger;

    public Printer(boolean debugger) {
        this.debugger = debugger;
    }

    public static void init(@NotNull Printer.Settings settings) {
        Printer.settings = settings;
    }

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    public boolean checks(@Nullable Object object) {
        if (object == null) {
            info("null");
            return false;
        }
        if (settings == null) {
            System.out.println(ConsoleColor.RED + "The logger has not been initialized." + ConsoleColor.RESET);
            System.out.println("[DEBUG] " + object);
            return false;
        }
        return true;
    }

    /**
     * Print a white message
     *
     * @param object The object to print
     */
    public void info(@Nullable Object object) {
        info(object, ConsoleColor.WHITE);
    }

    /**
     * Print a white message
     *
     * @param object The object to print
     */
    public void info(@Nullable Object object, @NotNull ConsoleColor color) {
        if (!checks(object)) return;
        //noinspection DataFlowIssue
        log(color + object.toString() + ConsoleColor.RESET, debugger);
    }

    /**
     * {@link Logger#info} alias
     *
     * @param object The object to print
     */
    public void log(@Nullable Object object) {
        info(object);
    }

    /**
     * Print a red message
     *
     * @param object The object to print
     */
    public void error(@Nullable Object object) {
        info(object, ConsoleColor.RED);
    }

    /**
     * Print a green message
     *
     * @param object The object to print
     */
    public void good(@Nullable Object object) {
        info(object, ConsoleColor.GREEN);
    }

    /**
     * Print a yellow message
     *
     * @param object The object to print
     */
    public void warn(@Nullable Object object) {
        info(object, ConsoleColor.YELLOW);
    }

    private void log(@NotNull String log, boolean debug) {
        if (settings.logTime()) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
            log = "[" + dtf.format(LocalDateTime.now()) + "] " + log;
        }

        if (settings.logToFile() && !debug) {
            FileUtils.writeToFile(ConsoleColor.clearString(log), settings.logFilesFolder());
        }

        if (settings.debugToFile() && debug) {
            FileUtils.writeToFile(ConsoleColor.clearString(log), settings.debugFilesFolder());
        }

        if (!debug) {
            logToConsole(log);
            return;
        }

        if (settings.debugToConsole()) {
            logToConsole(log);
        }
    }

    private void logToConsole(@NotNull String log) {
        System.out.println(log);
    }

    @Getter
    @Setter
    @Accessors(chain = true, fluent = true)
    @NoArgsConstructor
    public static class Settings {

        private @NotNull String logFilesFolder = "/logs/";
        private @NotNull String debugFilesFolder = "/debug/";
        private boolean logTime = false;
        private boolean logToFile = false;
        private boolean debugToFile = false;
        private boolean debugToConsole = false;

        public void build() {
            Printer.init(this);
        }

    }
}
