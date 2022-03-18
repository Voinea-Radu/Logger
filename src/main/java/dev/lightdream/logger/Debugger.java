package dev.lightdream.logger;


@SuppressWarnings("unused")
public class Debugger {

    public static void info(Object object) {
        if (!isEnabled()) {
            return;
        }
        Logger.info(object);
    }

    public static void log(Object object) {
        info(object);
    }

    public static void init(LoggableMain main) {
        Logger.init(main);
    }


    public static void color(ConsoleColors color, Object object) {
        Logger.info(color + object.toString() + ConsoleColors.RESET);
    }

    public static boolean isEnabled() {
        return Logger.main.debug();
    }

}
