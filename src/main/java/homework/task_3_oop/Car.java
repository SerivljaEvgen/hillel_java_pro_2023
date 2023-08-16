package homework.task_3_oop;

public class Car {
    public void start() {
        startElectricity();
        startCommand();
        startFuelSystem();
    }

    private void startFuelSystem() {
        System.out.println("3. Start Fuel System");
    }

    private void startCommand() {
        System.out.println("2. Start Required Command");
    }

    private void startElectricity() {
        System.out.println("1. Start Electricity");
    }

    public static void main(String[] args) {
        System.out.println("Car: ");
        Car car = new Car();
        car.start();
    }
}
