package homework.task_9_generics;

public class Main {
    public static void main(String[] args) {

        Box<Apple> appleBox1 = new Box<>();
        appleBox1.addSingleItem(new Apple());
        appleBox1.addSingleItem(new Apple());
        System.out.println("Weight of appleBox1: " + appleBox1.getWeight());

        Box<Apple> appleBox2 = new Box<>();
        Apple[] applesArray = {new Apple(), new Apple()};
        appleBox2.addItems(applesArray);

        System.out.println("Weight of appleBox2: " + appleBox2.getWeight());
        System.out.println("Comparing weight of appleBox1 with appleBox2: " + appleBox1.compare(appleBox2));

        Box<Orange> orangeBox1 = new Box<>();
        orangeBox1.addSingleItem(new Orange());
        orangeBox1.addSingleItem(new Orange());
        System.out.println("Weight of orangeBox1: " + orangeBox1.getWeight());
        System.out.println("Comparing weight of appleBox1 with orangeBox1: " + appleBox1.compare(orangeBox1));

        appleBox1.merge(appleBox2);
        System.out.println("After merging appleBox1 and appleBox2:");
        System.out.println("Weight of appleBox1: " + appleBox1.getWeight());
        System.out.println("Weight of appleBox2: " + appleBox2.getWeight());

        System.out.println("Trying to combine a box of oranges and apples:");
//       appleBox2.merge(orangeBox1);
//       не дает скомпилировать данную строку - не понимаю как изменить код, чтобы сработал кейс else

    }
}
