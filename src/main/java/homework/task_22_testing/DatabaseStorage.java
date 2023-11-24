package homework.task_22_testing;

public class DatabaseStorage<T> implements DataStorage<T> {

    private T storedData;
    @Override
    // демонстраційна симуляція взаємодії з базою даних

    public void save(T data) {
        // Реалізація зберігання даних в базі даних
        System.out.println("Saving data to the database: " + data);
        this.storedData = data;
    }

    @Override
    public T load() {
        // Реалізація завантаження даних з бази даних
        System.out.println("Loading data from the database: " + storedData);
        return storedData;
    }

}
