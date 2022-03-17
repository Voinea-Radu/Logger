package dev.lightdream.logger;


@SuppressWarnings("unused")
public class Debugger {

    public static void info(Object object) {
        if (object == null) {
            info("null");
            return;
        }
        info(object.toString());
    }

    public static void info(String message) {
        if (Logger.main == null) {
            System.out.println("The debugger has not been initialized.");
            return;
        }
        if (!Logger.main.debug()) {
            return;
        }
        Logger.main.log(message);
    }

    public static void init(LoggableMain main) {
        Logger.init(main);
    }

    public boolean isEnabled() {
        return Logger.enabled;
    }

}
