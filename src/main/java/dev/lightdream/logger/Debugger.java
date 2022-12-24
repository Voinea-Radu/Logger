package dev.lightdream.logger;


@SuppressWarnings("unused")
public class Debugger {

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    public static boolean checks(Object object) {
        if (object == null) {
            info("null");
            return false;
        }
        if (Logger.main == null) {
            System.out.println(ConsoleColors.RED + "The logger has not been initialized." + ConsoleColors.RESET);
            return false;
        }
        return true;
    }

    /**
     * Print a white message
     * @param object The object to print
     */
    public static void info(Object object) {
        if (!checks(object)) return;
        Logger.main.log(object.toString(), true);
    }

    /**
     * Print a colored message
     * @param color The color of the message
     * @param object The object to print
     */
    public static void color(ConsoleColors color, Object object) {
        if (!checks(object)) return;
        info(color + object.toString() + ConsoleColors.RESET);
    }

    /**
     * {@link Logger#info} alias
     * @param object The object to print
     */
    public static void log(Object object) {
        info(object);
    }

    /**
     * Print a red message
     * @param object The object to print
     */
    public static void error(Object object) {
        color(ConsoleColors.RED, object);
    }

    /**
     * Print a green message
     * @param object The object to print
     */
    public static void good(Object object) {
        color(ConsoleColors.GREEN, object);
    }

    /**
     * Print a yellow message
     * @param object The object to print
     */
    public static void warn(Object object) {
        color(ConsoleColors.YELLOW, object);
    }

    /**
     * Print a blue message
     * @param object The object to print
     */
    public static void setting(Object object) {
        color(ConsoleColors.BLUE, object);
    }
}
