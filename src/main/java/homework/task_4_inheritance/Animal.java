package homework.task_4_inheritance;

public class Animal {

    private static int count; // comment for myself:
    // static defines a static variable that is associated with the class itself and not with a specific class object.
    public Animal() {
        count++;
    }

    public void run(int obstacleLength) {
        System.out.println("Animal ran " + obstacleLength + " m");
    }

    public void swim(int distance) {
        System.out.println("Animal swam " + distance + " m");
    }

    public static int getCount() {
        return count;
    }
}
