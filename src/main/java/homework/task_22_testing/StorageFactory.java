package homework.task_22_testing;

public class StorageFactory {
    public static <T> DataStorage<T> createStorage(DataStorageType type, String filePath) {
        switch (type) {
            case IN_MEMORY:
                return new InMemoryStorage<>();
            case FILE_SYSTEM:
                return new FileStorage<>(filePath);
            case DATABASE:
                return new DatabaseStorage<>();
            default:
                throw new IllegalArgumentException("Unsupported data storage type: " + type);
        }
    }
}
