package dev.lightdream.logger;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true, fluent = true)
public class PrinterSettings {

    private String logFilesFolder = "/logs/";
    private String debugFilesFolder = "/debug/";
    private boolean logTime = false;
    private boolean logToFile = false;
    private boolean debugToFile = false;
    private boolean debugToConsole = false;

    public void build() {
        Printer.init(this);
    }

}
