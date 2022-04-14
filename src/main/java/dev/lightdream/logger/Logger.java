package dev.lightdream.logger;


@SuppressWarnings("unused")
public class Logger {

    public static boolean enabled = false;
    public static LoggableMain main;

    @SuppressWarnings("unused")
    public static void info(Object object) {
        if (object == null) {
            info("null");
            return;
        }
        if (main == null) {
            System.out.println(ConsoleColors.RED + "The logger has not been initialized." + ConsoleColors.RESET);
            return;
        }
        main.log(object.toString());
    }

    public static void log(Object object) {
        info(object);
    }

    public static void error(Object object) {
        color(ConsoleColors.RED, object);
    }

    public static void good(Object object) {
        color(ConsoleColors.GREEN, object);
    }

    public static void warn(Object object) {
        color(ConsoleColors.YELLOW, object);
    }

    public static void init(LoggableMain main) {
        Logger.main = main;
        Logger.enabled = true;
    }

    public static void color(ConsoleColors color, Object object) {
        if (object == null) {
            info("null");
            return;
        }

        if (main == null) {
            info(object);
            return;
        }

        info(color + object.toString() + ConsoleColors.RESET);
    }

    public static void setting(Object object) {
        color(ConsoleColors.BLUE, object);
    }
}
