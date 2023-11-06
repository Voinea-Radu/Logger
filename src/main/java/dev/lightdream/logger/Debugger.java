package dev.lightdream.logger;


@SuppressWarnings("unused")
public class Debugger {

    private static final Printer printer = new Printer(true);

    public static boolean isEnabled() {
        if (Printer.getSettings() == null) {
            return true;
        }
        return Printer.getSettings().debugToConsole();
    }

    /**
     * Print a white message
     *
     * @param object The object to print
     */
    public static void info(Object object) {
        printer.info(object);
    }

    /**
     * Print a white message
     *
     * @param object The object to print
     */
    public static void info(Object object, ConsoleColor color) {
        printer.info(object, color);
    }

    /**
     * {@link Logger#info} alias
     *
     * @param object The object to print
     */
    public static void log(Object object) {
        printer.log(object);
    }

    /**
     * Print a red message
     *
     * @param object The object to print
     */
    public static void error(Object object) {
        printer.error(object);
    }

    /**
     * Print a green message
     *
     * @param object The object to print
     */
    public static void good(Object object) {
        printer.good(object);
    }

    /**
     * Print a yellow message
     *
     * @param object The object to print
     */
    public static void warn(Object object) {
        printer.warn(object);
    }

    /**
     * Initializes the {@link Logger} and {@link Debugger} via the {@link Printer}
     *
     * @param settings The main class
     */
    public static void init(PrinterSettings settings) {
        Printer.init(settings);
    }
}
