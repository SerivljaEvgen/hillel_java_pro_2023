package homework.task_20_design_and_architecture.builder;

public class Car {
    private String manufacturer;
    private String model;
    private int year;
    private String color;

    //Constructor for the Car class (private, so you can only use it via the Builder)
    private Car() {
    }

    //getters
    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    //Inner Builder-class
    static class Builder {
        private Car car;

        //Builder constructor
        public Builder() {
            car = new Car();
        }
        // Builders set methods for car

        // return this - просто повертають поточні об'єкти будівельника, дозволяючи викликати
        // наступний метод на цьому об'єкті в ланцюговій послідовності.
        public Builder setManufacturer (String manufacturer){
            car.manufacturer = manufacturer;
            return this;
        }

        public Builder setModel(String model) {
            car.model = model;
            return this;
        }

        public Builder setYear(int year) {
            car.year = year;
            return this;
        }

        public Builder setColor(String color) {
            car.color = color;
            return this;
        }

        //Method for building the car object
        public Car build(){
            return car;
        }





    }
}
