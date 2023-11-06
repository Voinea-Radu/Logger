# Logger

![Build](../../actions/workflows/build.yml/badge.svg)
![Version](https://img.shields.io/badge/Version-4.0.0-red.svg)

# Table Of Contents

1. [Description](#description)
2. [How to add to your project](#how-to-add-to-your-project)
3. [How to use](#how-to-use)

## Description

A simple logger library used by many others proprietary libs and projects. This library allows you to enable and disable
logging or debugging to console and files as well as include or not timestamps.

## How to add to your project

The artifact can be found at the repository https://repo.lightdream.dev or https://jitpack.io (under
com.github.L1ghtDream instead of dev.lightdream)

### Maven

```xml

<repositories>
    <repository>
        <id>lightdream-repo</id>
        <url>https://repo.lightdream.dev/</url>
    </repository>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

```xml

<dependencies>
    <dependency>
        <groupId>dev.lightdream</groupId>
        <artifactId>logger</artifactId>
        <version>4.0.0</version>
    </dependency>
    <dependency>
        <groupId>com.github.L1ghtDream</groupId>
        <artifactId>logger</artifactId>
        <version>4.0.0</version>
    </dependency>
</dependencies>
```

### Gradle - Groovy DSL

```groovy
repositories {
    maven { url "https://repo.lightdream.dev/" }
    maven { url "https://jitpack.io" }
}

dependencies {
    implementation "dev.lightdream:logger:4.0.0"
    implementation "com.github.L1ghtDream:logger:4.0.0"
}
```

### Gradle - Kotlin DSL

```kotlin
repositories {
    maven("https://repo.lightdream.dev/")
    maven("https://jitpack.io")
}

dependencies {
    implementation("dev.lightdream:logger:4.0.0")
    implementation("com.github.L1ghtDream:logger:4.0.0")
}
```

If you want to use an older version that is not available in https://repo.lightdream.dev you can try
using https://archive-repo.lightdream.dev

## How to use

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
