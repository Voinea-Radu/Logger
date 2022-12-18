package dev.lightdream.logger.example;

import dev.lightdream.logger.Debugger;
import dev.lightdream.logger.LoggableMain;
import dev.lightdream.logger.Logger;

@SuppressWarnings("unused")
public class Example implements LoggableMain {

    public Example() {
        enable();

        Logger.log("Hello World!");
        Logger.error("Hello World!");

        Debugger.log("Hello World!");
    }

    public void enable() {
        Logger.init(this);
        Debugger.init(this);
    }

    @Override
    public boolean debug() {
        return true;
    }

    @Override
    public void log(String s) {
        System.out.println(s);
    }
}