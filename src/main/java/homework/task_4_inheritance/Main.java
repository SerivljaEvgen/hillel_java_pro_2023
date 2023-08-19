package homework.task_4_inheritance;

public class Main {
    public static void main(String[] args) {
        Animal cat1 = new Cat("Barsik");
        cat1.run(50);
        cat1.swim(5);

        Cat cat2 = new Cat("Pushok");
        cat2.run(250);

        Animal dog1 = new Dog("Bobik");
        dog1.run(200);
        dog1.swim(9);

        Dog dog2 = new Dog("CrazyDog");
        dog2.run(10000);
        dog2.swim(1000);

        System.out.println("\nCount of created cats, dogs and animals: " + Animal.getCount());

    }
}
