package homework.task_22_testing;

import java.util.ArrayList;
import java.util.List;

public class InMemoryStorage<T> implements DataStorage<T> {

    private final List<T> data;

    public InMemoryStorage() {
        this.data = new ArrayList<>();
    }

    @Override
    public void save(T data) {
        this.data.add(data);
    }

    @Override
    public T load() {
        // Реалізація завантаження даних з пам'яті
        if (!data.isEmpty()) {
            return data.get(data.size() - 1);
        } else {
            return null;
        }
    }
}
