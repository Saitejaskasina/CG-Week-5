import java.io.*;
import java.util.*;

class Employee {
    int id;
    String name, department;
    double salary;

    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + department + "," + salary;
    }
}

public class DatabaseToCSV {
    public static void main(String[] args) {
        String filePath = "employee_report.csv";
        List<Employee> employees = List.of(
            new Employee(201, "Mike", "HR", 50000),
            new Employee(202, "Jane", "IT", 60000),
            new Employee(203, "Robert", "Finance", 55000),
            new Employee(204, "Emily", "IT", 65000),
            new Employee(205, "Tom", "Marketing", 48000)
        );

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Employee ID,Name,Department,Salary\n");
            for (Employee emp : employees) {
                writer.write(emp.toString() + "\n");
            }
            System.out.println("CSV report generated successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}