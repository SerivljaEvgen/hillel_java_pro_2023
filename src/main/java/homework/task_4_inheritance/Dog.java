package homework.task_4_inheritance;

public class Dog extends Animal {

    private String dogName;

    public Dog(String dogName) {
        this.dogName = dogName;
    }

    public String getDogName() {
        return dogName;
    }

    @Override
    public void run(int obstacleLength) {
        if (obstacleLength <= 500) {
            System.out.println("Dog " + getDogName() + " ran " + obstacleLength + " m");
        } else {
            System.out.println(obstacleLength + " m is too much for the dog " + getDogName());
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= 10) {
            System.out.println("Dog " + getDogName() + " swam " + distance + " m");
        } else {
            System.out.println(distance + " m swimming is too long for the dog " + getDogName());
        }
    }
}
