package dev.lightdream.logger;

public class TestMain {

    public TestMain() {
        PrinterSettings settings = new PrinterSettings()
                .debugToConsole(true)
                .logFilesFolder("tmp-logs")
                .debugFilesFolder("tmp-debugs")
                .logToFile(true)
                .debugToFile(true);

        settings.build();
    }

}
