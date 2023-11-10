package homework.task_17_files_io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;

import static java.nio.charset.StandardCharsets.UTF_8;

public class FileLogger {

    private final FileLoggerConfiguration config; // буде записуватися в log

    public FileLogger(FileLoggerConfiguration config) {
        this.config = config;
    }

    public void info(String message){
    //Формат запису: [ПОТОЧНИЙ_ЧАС][INFO] Повідомлення: [СТРОКА-ПОВІДОМЛЕННЯ]
        StringBuilder output = new StringBuilder();
        output.append("[");
        output.append(LocalDateTime.now());//ПОТОЧНИЙ_ЧАС
        output.append("]");
        output.append("[INFO]");
        output.append(" Message: ");
        output.append(message);
        String result = output.toString();

        try (OutputStream out = new BufferedOutputStream(new FileOutputStream(config.path() + "/" + config.prefix()))) { // абстрактный класс OutputStream
                out.write((result).getBytes(UTF_8)); // запись
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void debug(String message){
        //Формат запису: [ПОТОЧНИЙ_ЧАС][DEBUG] Повідомлення: [СТРОКА-ПОВІДОМЛЕННЯ]
        if(config.level().equals(LoggingLevel.INFO)){
            return;
        }
        StringBuilder output = new StringBuilder();
        output.append("[");
        output.append(LocalDateTime.now());//ПОТОЧНИЙ_ЧАС
        output.append("]");
        output.append("[DEBUG]");
        output.append(" Message: ");
        output.append(message);
        String result = output.toString();

        try (OutputStream out = new BufferedOutputStream(new FileOutputStream(config.path() + "/" + config.prefix()))) {
            out.write((result).getBytes(UTF_8)); // запись
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
