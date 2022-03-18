package dev.lightdream.logger;

public interface LoggableMain {

    @SuppressWarnings("unused")
    static String getVersion() {
        return "Logger 2.2.5";
    }

    boolean debug();

    void log(String log);

}