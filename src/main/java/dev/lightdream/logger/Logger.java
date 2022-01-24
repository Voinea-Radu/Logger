package dev.lightdream.logger;

import org.fusesource.jansi.Ansi;

@SuppressWarnings("unused")
public class Logger {

    public static boolean enabled = false;
    private static dev.lightdream.logger.LoggableMain main;

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
            System.out.println(Ansi.ansi().fg(Ansi.Color.RED).boldOff() + "The logger has not been initialized." + Ansi.ansi()
                    .fg(Ansi.Color.DEFAULT)
                    .boldOff());
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
        info(Ansi.ansi().fg(Ansi.Color.RED).boldOff() + message + Ansi.ansi().fg(Ansi.Color.DEFAULT).boldOff());
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
        info(Ansi.ansi().fg(Ansi.Color.GREEN).boldOff() + message + Ansi.ansi().fg(Ansi.Color.DEFAULT).boldOff());
    }

    public static void init(LoggableMain main) {
        Logger.main = main;
        Logger.enabled = true;
    }

    public static void color(Ansi.Color color, Object object) {
        if (object == null) {
            error("null");
            return;
        }
        color(color, object.toString());
    }

    public static void color(Ansi.Color color, String message) {
        info(Ansi.ansi().fg(color).boldOff() + message + Ansi.ansi().fg(Ansi.Color.DEFAULT).boldOff());
    }

    public static void setting(Object object) {
        if (object == null) {
            setting("null");
            return;
        }
        setting(object.toString());
    }

    public static void setting(String message) {
        info(Ansi.ansi().fg(Ansi.Color.BLUE).boldOff() + message + Ansi.ansi().fg(Ansi.Color.DEFAULT).boldOff());
    }

}
