package dev.lightdream.logger;

import lombok.Getter;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Accessors(chain = true, fluent = true)
public class Printer {

    static {
        builder().build();
    }

    private final @NotNull String logFilesFolder;
    private final @NotNull String debugFilesFolder;
    private final boolean logTime;
    private final boolean logToFile;
    private final boolean debugToFile;
    private final boolean debugToConsole;
    private final boolean debugger;

    @lombok.Builder(builderClassName = "_Builder")
    private Printer(@NotNull String logFilesFolder, @NotNull String debugFilesFolder, boolean logTime,
                    boolean logToFile, boolean debugToFile, boolean debugToConsole, boolean debugger) {
        this.debugger = debugger;
        this.logFilesFolder = logFilesFolder;
        this.debugFilesFolder = debugFilesFolder;
        this.logTime = logTime;
        this.logToFile = logToFile;
        this.debugToFile = debugToFile;
        this.debugToConsole = debugToConsole;
    }

    public static Builder builder() {
        return (Builder) new Builder()
                .logFilesFolder("/logs/")
                .debugFilesFolder("/debug/")
                .logTime(false)
                .logToFile(false)
                .debugToFile(false)
                .debugToConsole(false);
    }

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    public boolean checks(@Nullable Object object) {
        if (object == null) {
            info("null");
            return false;
        }
        return true;
    }

    public void info(@Nullable Object object) {
        info(object, ConsoleColor.WHITE);
    }

    public void info(@Nullable Object object, @NotNull ConsoleColor color) {
        if (!checks(object)) return;
        //noinspection DataFlowIssue
        log(color + object.toString() + ConsoleColor.RESET, debugger);
    }

    public void log(@Nullable Object object) {
        info(object);
    }

    public void error(@Nullable Object object) {
        info(object, ConsoleColor.RED);
    }

    public void good(@Nullable Object object) {
        info(object, ConsoleColor.GREEN);
    }

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
