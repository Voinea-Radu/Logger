package dev.lightdream.logger;


import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class Logger {

    private static final Printer printer = new Printer(false);

    /**
     * Print a white message
     *
     * @param object The object to print
     */
    public static void info(@Nullable Object object) {
        printer.info(object);
    }

    /**
     * Print a white message
     *
     * @param object The object to print
     */
    public static void info(@Nullable Object object, @NotNull ConsoleColor color) {
        printer.info(object, color);
    }

    /**
     * {@link Logger#info} alias
     *
     * @param object The object to print
     */
    public static void log(@Nullable Object object) {
        printer.log(object);
    }

    /**
     * Print a red message
     *
     * @param object The object to print
     */
    public static void error(@Nullable Object object) {
        printer.error(object);
    }

    /**
     * Print a green message
     *
     * @param object The object to print
     */
    public static void good(@Nullable Object object) {
        printer.good(object);
    }

    /**
     * Print a yellow message
     *
     * @param object The object to print
     */
    public static void warn(@Nullable Object object) {
        printer.warn(object);
    }

    /**
     * Initializes the {@link Logger} and {@link Debugger} via the {@link Printer}
     *
     * @param settings The settings
     */
    public static void init(@NotNull Printer.Settings settings) {
        Printer.init(settings);
    }
}
