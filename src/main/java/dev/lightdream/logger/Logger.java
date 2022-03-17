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
        info(object.toString());
    }

    public static void info(String message) {
        if (main == null) {
            System.out.println(ConsoleColors.RED + "The logger has not been initialized." + ConsoleColors.RESET);
            return;
        }
        main.log(message);
    }

    public static void error(Object object) {
        if (object == null) {
            error("null");
            return;
        }
        error(object.toString());
    }

    public static void error(String message) {
        if (main == null) {
            info(message);
            return;
        }
        info(ConsoleColors.RED + message + ConsoleColors.RESET);
    }

    public static void good(Object object) {
        if (object == null) {
            good("null");
            return;
        }
        good(object.toString());
    }

    public static void good(String message) {
        if (main == null) {
            info(message);
            return;
        }

        info(ConsoleColors.GREEN + message + ConsoleColors.RESET);
    }

    public static void init(LoggableMain main) {
        Logger.main = main;
        Logger.enabled = true;
    }

    public static void color(ConsoleColors color, Object object) {
        if (object == null) {
            error("null");
            return;
        }
        color(color, object.toString());
    }

    public static void setting(Object object) {
        if (object == null) {
            setting("null");
            return;
        }
        setting(object.toString());
    }

    public static void setting(String message) {
        info(ConsoleColors.BLUE + message + ConsoleColors.RESET);
    }

    public boolean isEnabled() {
        return enabled;
    }

}
