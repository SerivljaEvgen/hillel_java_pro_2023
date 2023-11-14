package homework.task_20_design_and_architecture.builder;

public class CarClient {
    public static void main(String[] args) {
        //We use the Builder to create the car object
        Car car = new Car.Builder()
                .setManufacturer("Tesla")
                .setModel("Model S")
                .setYear(2022)
                .setColor("Red")
                .build();

        System.out.println("Manufacturer: " + car.getManufacturer());
        System.out.println("Model: " + car.getModel());
        System.out.println("Year: " + car.getYear());
        System.out.println("Color: " + car.getColor());

    }
}
