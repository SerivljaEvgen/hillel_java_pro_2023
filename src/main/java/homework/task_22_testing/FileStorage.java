package homework.task_22_testing;

import java.io.*;

public class FileStorage<T> implements DataStorage<T> {
    private final String filePath;

    public FileStorage(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void save(T data) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))){
            oos.writeObject(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public T load() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            // Читаємо об'єкт з файлу та повертаємо його
            return (T) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
