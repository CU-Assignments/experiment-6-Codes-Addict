import java.util.*;
import java.util.stream.Collectors;

class Student {
    String name;
    double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', marks=" + marks + '}';
    }
}

public class Medium {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Nikhil", 85.5),
                new Student("Aryan", 72.0),
                new Student("Chirag", 90.0),
                new Student("Dharam", 65.5),
                new Student("bhavesh", 88.0)
        );

        List<Student> filteredAndSortedStudents = students.stream()
                .filter(student -> student.getMarks() > 75)
                .sorted(Comparator.comparingDouble(Student::getMarks).reversed())
                .collect(Collectors.toList());

        System.out.println("Students scoring above 75% and sorted by marks:");
        filteredAndSortedStudents.forEach(student -> System.out.println(student.getName()));
    }
}