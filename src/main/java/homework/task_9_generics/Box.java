package homework.task_9_generics;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private final ArrayList<T> fruits = new ArrayList<>();

    public void addSingleItem(T item) {
        if (fruits.isEmpty() || fruits.get(0).getClass() == item.getClass()) {
            fruits.add(item);
        } else {
            System.out.println("It's' not possible to add different types of fruit to the box");
        }
    }

    public void addItems(T[] items) {
        for (T item : items) {
            addSingleItem(item);
        }
    }

    public Float getWeight() {
        float totalWeight = 0F;
        for (T item : fruits) {
            totalWeight += item.getWeightOfOneUnit();
        }
        return totalWeight;
    }

    //                         Вопросы !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // Работает, но не понимаю ставить Box<?> или Box<T>, или Box<? extends Fruit> и почему?
    public boolean compare(Box<?> anotherBox) {
        //  Если они имеют почти одинаковый вес (с учетом дробной части), метод вернет true, иначе – false
        return Math.abs(this.getWeight() - anotherBox.getWeight()) < 0.0001;
    }

    // Сделал с помощью chatGPT и все равно appleBox2.merge(orangeBox1) в Main не компилируется - не понимаю как сделать,
    // чтобы срабатывал блок else;
    // Также не понимаю ставить Box<?> или Box<T> или Box<? extends Fruit> или... и почему?
    // Подскажите пожалуйста.
    public void merge(Box<T> anotherBox) {
        if (this == anotherBox) {
            System.out.println("Unable to merge box with itself");
        }

        if (this.fruits.isEmpty()) {
            this.fruits.addAll(anotherBox.fruits);
            anotherBox.fruits.clear();
        } else if (this.fruits.get(0).getClass() == anotherBox.fruits.get(0).getClass()) {
            this.fruits.addAll(anotherBox.fruits);
            anotherBox.fruits.clear();
        } else {
            System.out.println("Unable to merge boxes with different types of fruit");
        }

    }


}


