package dev.lightdream.logger;

public class TestMain implements LoggableMain{

    public TestMain(){
        Logger.init(this);
    }

    @Override
    public boolean debugToConsole() {
        return true;
    }

    @Override
    public String logFilesFolder() {
        return "tmp-logs";
    }

    @Override
    public String debugFilesFolder() {
        return "tmp-debugs";
    }

    @Override
    public boolean logToFile() {
        return true;
    }

    @Override
    public boolean debugToFile() {
        return true;
    }
}
