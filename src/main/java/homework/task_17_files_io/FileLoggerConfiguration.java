package homework.task_17_files_io;

public record FileLoggerConfiguration(
        //файл, куди буде записуватися інформація
        String path, // ./logs - folder
        String prefix, //файл log...

        LoggingLevel level, //поточний рівень логування INFO or DEBUG
        int maxSize  // максимальний розмір файлу (в байтах)
) {
}
