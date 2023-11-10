package homework.task_17_files_io;

public class Main {
    public static void main(String[] args) {
        //1
        FileLoggerConfiguration configInfo = new FileLoggerConfiguration(
                "./logs",
                "log1.txt",
                LoggingLevel.DEBUG,
                512);

        FileLogger fileLogger = new FileLogger(configInfo);

        fileLogger.debug("My debug message");
       // fileLogger.info("My info message");
    }
}
