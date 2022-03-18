package dev.lightdream.logger;

public interface LoggableMain {

    @SuppressWarnings("unused")
    static String getVersion() {
        return "Logger " + LoggableMain.class.getPackage().getImplementationVersion();
    }

    boolean debug();

    void log(String log);

}