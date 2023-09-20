package homework.task_11_lists;


public class ClassForTask5 {
    private final String name;
    private final int occurrence;

    public ClassForTask5(String name, int occurrence) {
        this.name = name;
        this.occurrence = occurrence;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", occurrence=" + occurrence +
                '}';
    }
}
