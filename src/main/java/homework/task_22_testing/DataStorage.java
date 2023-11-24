package homework.task_22_testing;

public interface DataStorage<T> {
    void save(T data);
    T load();
}
