package homework.task_11_lists.phonebook;

import java.util.List;

public class Entries {
    private final String name;
    private final List<String> phoneNumber;

    public Entries(String name, List<String> phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public List<String> getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
