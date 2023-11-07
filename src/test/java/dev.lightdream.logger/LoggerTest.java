package dev.lightdream.logger;

import lombok.SneakyThrows;
import org.junit.jupiter.api.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoggerTest {

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @BeforeAll
    public static void init() {
        Printer.builder()
                .logFilesFolder("tmp-logs")
                .debugFilesFolder("tmp-debugs")
                .debugToConsole(true)
                .logToFile(true)
                .debugToFile(true)
                .build();

        File file1 = getLogFile();
        File file2 = getDebugFile();

        if (file1.exists()) {
            file1.delete();
        }
        if (file2.exists()) {
            file2.delete();
        }
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @AfterAll
    public static void cleanup() {
        File file1 = getLogFile();
        File file2 = getLogFolder();
        File file3 = getDebugFile();
        File file4 = getDebugFolder();

        if (file1.exists()) {
            file1.delete();
        }

        if (file2.exists()) {
            file2.delete();
        }

        if (file3.exists()) {
            file3.delete();
        }

        if (file4.exists()) {
            file4.delete();
        }
    }

    private static File getLogFolder() {
        return new File(System.getProperty("user.dir") + "/tmp-logs");
    }

    private static File getDebugFolder() {
        return new File(System.getProperty("user.dir") + "/tmp-debugs");
    }

    private static File getLogFile() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        return new File(getLogFolder().getPath() + "/" + dtf.format(LocalDateTime.now()) + ".log");
    }

    private static File getDebugFile() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        return new File(getDebugFolder().getPath() + "/" + dtf.format(LocalDateTime.now()) + ".log");
    }

    @SneakyThrows
    @Test
    @Order(1)
    public void testLogger() {
        Logger.log("Test log 1");
        Logger.info("Test log 2", ConsoleColor.WHITE_BRIGHT);
        Logger.good("Test log 3");
        Logger.warn("Test log 4");
        Logger.error("Test log 5");

        assertTrue(getLogFile().exists());

        StringBuilder builder = new StringBuilder();

        try (BufferedReader buffer = new BufferedReader(new FileReader(getLogFile()))) {
            String str;

            while ((str = buffer.readLine()) != null) {
                builder.append(str).append("\n");
            }
        }

        assertEquals(
                builder.toString(),
                "Test log 1\n" +
                        "Test log 2\n" +
                        "Test log 3\n" +
                        "Test log 4\n" +
                        "Test log 5\n"
        );

    }

    @SneakyThrows
    @Test
    @Order(2)
    public void testDebugger() {
        Debugger.log("Test debug 1");
        Debugger.info("Test debug 2", ConsoleColor.CYAN);
        Debugger.good("Test debug 3");
        Debugger.warn("Test debug 4");
        Debugger.error("Test debug 5");

        assertTrue(getDebugFile().exists());

        StringBuilder builder = new StringBuilder();

        try (BufferedReader buffer = new BufferedReader(new FileReader(getDebugFile()))) {
            String str;

            while ((str = buffer.readLine()) != null) {
                builder.append(str).append("\n");
            }
        }

        assertEquals(
                builder.toString(),
                "Test debug 1\n" +
                        "Test debug 2\n" +
                        "Test debug 3\n" +
                        "Test debug 4\n" +
                        "Test debug 5\n"
        );
    }
}
