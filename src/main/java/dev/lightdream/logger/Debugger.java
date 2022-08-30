package dev.lightdream.logger;


@SuppressWarnings("unused")
public class Debugger {

    private static boolean lowLevelEnabled = false;

    public static void enableLowLevelDebugging() {
        lowLevelEnabled = true;
    }

    public static void disableLowLevelDebugging() {
        lowLevelEnabled = false;
    }

    public static boolean isLowLevelDebuggingEnabled() {
        return lowLevelEnabled;
    }

    public static void info(Object object) {
        if (!isEnabled()) {
            return;
        }
        Logger.info(object);
    }

    public static void log(Object object) {
        log(object, false);
    }

    public static void log(Object object, boolean lowLevel) {
        if (lowLevel) {
            if (lowLevelEnabled) {
                info(object);
            }
            return;
        }
        info(object);
    }

    public static void init(LoggableMain main) {
        Logger.init(main);
    }

    public static void color(ConsoleColors color, Object object) {
        Logger.info(color + object.toString() + ConsoleColors.RESET);
    }

    public static boolean isEnabled() {
        try {
            return Logger.main.debug();
        } catch (Exception e) {
            return false;
        }
    }

}
