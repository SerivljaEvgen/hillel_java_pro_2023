package homework.task_5_polymorphism.figures;

public class Main {
    public static void main(String[] args) {
        //for myself:
        // Create an array of objects of 3 classes
        //thanks to polymorphism, we can store objects of different classes in an array and
        // call their method without explicit type casting.

        Figure[] figuresArray = new Figure[]{
                new Circle(10),
                new Square(7),
                new Triangle(5, 7)
        };

        System.out.printf("%.2f", calculateTotalArea(figuresArray));
    }

    private static double calculateTotalArea(Figure[] figuresArray) {
        double sum = 0;
        for (Figure figure : figuresArray) {
            sum += figure.getCalculateArea();
        }
        System.out.print("Total area of all figures in array: ");
        return sum;
    }
}
