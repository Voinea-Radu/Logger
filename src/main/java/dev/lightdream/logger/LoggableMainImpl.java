package dev.lightdream.logger;

@SuppressWarnings("unused")
public class LoggableMainImpl implements LoggableMain {

    private boolean debug;

    public LoggableMainImpl(boolean debug) {
        this.debug = debug;
    }

    public LoggableMainImpl() {
        this.debug = false;
    }

    public void debug(boolean debug) {
        this.debug = debug;
    }

    @Override
    public boolean debug() {
        return debug;
    }

    @Override
    public void log(String log) {
        System.out.println(log);
    }
}