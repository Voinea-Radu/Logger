package dev.lightdream.logger;

import lombok.Getter;

public class Printer {

    private static @Getter LoggableMain main;
    private final boolean debugger;

    public Printer(boolean debugger) {
        this.debugger = debugger;
    }

    public static void init(LoggableMain main) {
        Printer.main = main;
    }

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    public boolean checks(Object object) {
        if (object == null) {
            info("null");
            return false;
        }
        if (main == null) {
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
    public void info(Object object) {
        info(object, ConsoleColor.WHITE);
    }

    /**
     * Print a white message
     *
     * @param object The object to print
     */
    public void info(Object object, ConsoleColor color) {
        if (!checks(object)) return;
        main.log(color.toString() + object.toString() + ConsoleColor.RESET, debugger);
    }

    /**
     * {@link Logger#info} alias
     *
     * @param object The object to print
     */
    public void log(Object object) {
        info(object);
    }

    /**
     * Print a red message
     *
     * @param object The object to print
     */
    public void error(Object object) {
        info(object, ConsoleColor.RED);
    }

    /**
     * Print a green message
     *
     * @param object The object to print
     */
    public void good(Object object) {
        info(object, ConsoleColor.GREEN);
    }

    /**
     * Print a yellow message
     *
     * @param object The object to print
     */
    public void warn(Object object) {
        info(object, ConsoleColor.YELLOW);
    }
}
