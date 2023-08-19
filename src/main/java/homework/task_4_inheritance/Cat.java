package homework.task_4_inheritance;

public class Cat extends Animal {

    private String catName;

    public Cat(String catName) {
        this.catName = catName;
    }

    public String getCatName() {
        return catName;
    }

    @Override
    public void run(int obstacleLength) {
        if (obstacleLength <= 200) {
            System.out.println("Cat " + getCatName() + " ran " + obstacleLength + " m");
        } else {
            System.out.println(obstacleLength + " m is too much for the cat " + getCatName());
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println("Cat can't swim");
    }
}
