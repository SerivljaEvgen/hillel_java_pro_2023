package homework.task_3_oop;

public class Employee {
    private String fullName;
    private String position;
    private String email;
    private String phone;
    private int age;

    public Employee(String fullName, String position, String email, String phone, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee: \n" +
                "fullName: '" + fullName + '\'' +
                ", position: '" + position + '\'' +
                ", email: '" + email + '\'' +
                ", phone: '" + phone + '\'' +
                ", age: " + age;
    }

    public static void main(String[] args) {
        Employee employee = new Employee("John Smith", "manager", "J.Smith@gmail.com",
                "+38 050-605-43-45", 35);
        System.out.println(employee);
    }
}
