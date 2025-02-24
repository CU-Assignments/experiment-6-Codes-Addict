import java.util.*;
import java.util.stream.Collectors;

class Employee {
    String name;
    int age;
    double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', age=" + age + ", salary=" + salary + '}';
    }
}

public class Easy {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Nikhil", 21, 70000),
                new Employee("Shivansh", 25, 50000),
                new Employee("Charminar", 35, 90000),
                new Employee("Harsh", 28, 60000)
        );

        List<Employee> sortedBySalary = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .collect(Collectors.toList());

        System.out.println("Employees sorted by salary:");
        sortedBySalary.forEach(System.out::println);
    }
}