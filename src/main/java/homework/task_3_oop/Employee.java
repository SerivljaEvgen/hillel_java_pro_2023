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

    public String getFullName() {
        return fullName;
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public int getAge() {
        return age;
    }

    public static void main(String[] args) {
        Employee employee = new Employee("John Smith", "manager", "J.Smith@gmail.com",
                "+38 050-605-43-45", 35);
        System.out.println("Employee information: \n" + employee.getFullName() + "\n" + employee.getPosition() + "\n" +
                employee.getEmail() + "\n" + employee.getPhone() + "\n" + employee.getAge());
    }
}
