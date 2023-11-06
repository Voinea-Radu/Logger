package dev.lightdream.logger;

public class TestMain {

    public TestMain() {
        Printer.Settings settings = new Printer.Settings()
                .debugToConsole(true)
                .logFilesFolder("tmp-logs")
                .debugFilesFolder("tmp-debugs")
                .logToFile(true)
                .debugToFile(true);

        settings.build();
    }

}
