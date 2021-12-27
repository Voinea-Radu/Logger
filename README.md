# LightDream Logger

![Build](https://github.com/L1ghtDream/LightDreamAPI/actions/workflows/build.yml/badge.svg)

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
        <version>VERSION</version>
    </dependency>
    <!-- Other dependencies -->
</dependencies>
```

## Example

```java

public class Example implements LoggableMain {

  public Example(){
    enable();
  }

  public void enable(){
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


