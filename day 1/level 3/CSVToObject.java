import java.io.*;
import java.util.*;

class Student {
    int id, age, marks;
    String name;

    Student(int id, String name, int age, int marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return id + " - " + name + " - Age: " + age + " - Marks: " + marks;
    }
}

public class CSVToObject {
    public static void main(String[] args) {
        String filePath = "students.csv";
        List<Student> students = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            reader.readLine(); // Skip header
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                students.add(new Student(Integer.parseInt(fields[0]), fields[1], Integer.parseInt(fields[2]), Integer.parseInt(fields[3])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        students.forEach(System.out::println);
    }
}