### The main function

All the methods have JavaDocs for what each of them do.
More methods that can customize the behaviour of the Logger and Debugger by overriding methods of LoggableMain

```java
public class ExampleMain implements LoggableMain {

    @Override
    public boolean debugToConsole() {
        return true;
    }

}
```

### How to use the Logger class
```java
public class UserLogger {

    public void log() {
        Logger.log("This is a log message");
        Logger.info("This is a colored message", ConsoleColor.CYAN);
        Logger.good("This is a success message");
        Logger.warn("This is a warning message");
        Logger.error("This is an error message");
    }
}
```


### How to use the Debugger class
This class can only be used if the ExampleMain#debugToConsole is returning true
```java
public class UseDebugger {

    public void foo() {
        Debugger.log("This is a debug message");
        Debugger.info("This is a colored debug message", ConsoleColor.CYAN);
        Debugger.good("This is a success debug message");
        Debugger.warn("This is a warning debug message");
        Debugger.error("This is an error debug message");
    }
}
```