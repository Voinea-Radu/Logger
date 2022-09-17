# LightDream Logger

![Build](https://github.com/L1ghtDream/Logger/actions/workflows/build.yml/badge.svg)
![Build](https://img.shields.io/badge/Version-${{ env.VERSION }}-red.svg)

A logger lib that allows the separation of debugging logs and production logs.

## Use

### Maven

```xml
<repositories>
    <repository>
        <id>lightdream-repo</id>
        <url>https://repo.lightdream.dev/repository/LightDream-API/</url>
    </repository>
    <!-- Other repositories -->
</repositories>
```

```xml

<dependencies>
    <dependency>
        <groupId>dev.lightdream</groupId>
        <artifactId>Logger</artifactId>
        <version>${{ env.VERSION }}</version>
    </dependency>
    <!-- Other dependencies -->
</dependencies>
```

### Gradle

```gradle
repositories {
    maven { url "https://repo.lightdream.dev/repository/LightDream-API/" }
    
    // Other repositories
}

dependencies {
    implementation "dev.lightdream:Logger:${{ env.VERSION }}"
    
    // Other dependencies
}
```

## Example

```java

public class Example implements LoggableMain {

    public Example() {
        enable();
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

```


