# Logger

![Build](../../actions/workflows/build.yml/badge.svg)
![Version](https://img.shields.io/badge/Version-2.4.5-red.svg)

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
        <version>2.4.5</version>
    </dependency>
    <!-- Other dependencies -->
</dependencies>
```

### Gradle

```groovy
repositories {
    maven { url "https://repo.lightdream.dev/repository/LightDream-API/" }

    // Other repositories
}

dependencies {
    implementation "dev.lightdream:Logger:2.4.5"

    // Other dependencies
}
```

## Example

Can be found in the [source code](/src/main/java/dev/lightdream/logger/example)
