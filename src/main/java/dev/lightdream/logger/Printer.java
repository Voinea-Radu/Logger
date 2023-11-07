package dev.lightdream.logger;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Builder(builderClassName = "_Builder", toBuilder = true)
@Getter
@Setter
@Accessors(chain = true, fluent = true)
public class Printer {

    static {
        builder().build();
    }

    @lombok.Builder.Default
    private boolean debugger = false;
    @lombok.Builder.Default
    @NotNull
    private String logFilesFolder = "/logs/";
    @lombok.Builder.Default
    @NotNull
    private String debugFilesFolder = "/debug/";
    @lombok.Builder.Default
    private boolean logTime = false;
    @lombok.Builder.Default
    private boolean logToFile = false;
    @lombok.Builder.Default
    private boolean debugToFile = false;
    @lombok.Builder.Default
    private boolean debugToConsole = false;

    public static Builder builder() {
        return new Builder();
    }

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    public boolean checks(@Nullable Object object) {
        if (object == null) {
            info("null");
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
        if (logTime()) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
            log = "[" + dtf.format(LocalDateTime.now()) + "] " + log;
        }

        if (logToFile() && !debug) {
            FileUtils.writeToFile(ConsoleColor.clearString(log), logFilesFolder());
        }

        if (debugToFile() && debug) {
            FileUtils.writeToFile(ConsoleColor.clearString(log), debugFilesFolder());
        }

        if (!debug) {
            logToConsole(log);
            return;
        }

        if (debugToConsole()) {
            logToConsole(log);
        }
    }

    private void logToConsole(@NotNull String log) {
        System.out.println(log);
    }

    public static class Builder extends _Builder {
        @Override
        public Printer build() {
            // We need to call it multiple times to get multiple instances
            Printer output = super.build();
            this.debugger(false);
            Printer logPrinter = super.build();
            this.debugger(true);
            Printer debugPrinter = super.build();

            Logger.init(logPrinter);
            Debugger.init(debugPrinter);

            return output;
        }
    }
}
