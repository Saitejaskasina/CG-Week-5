import java.io.*;
import java.util.*;

public class CSVMerge {
    public static void main(String[] args) {
        String file1 = "students1.csv";
        String file2 = "students2.csv";
        String outputFile = "merged_students.csv";

        Map<String, String[]> studentData = new HashMap<>();

        try (BufferedReader reader1 = new BufferedReader(new FileReader(file1))) {
            reader1.readLine(); // Skip header
            String line;
            while ((line = reader1.readLine()) != null) {
                String[] fields = line.split(",");
                studentData.put(fields[0], fields);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader reader2 = new BufferedReader(new FileReader(file2));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write("ID,Name,Age,Marks,Grade\n");
            reader2.readLine(); // Skip header
            String line;
            while ((line = reader2.readLine()) != null) {
                String[] fields = line.split(",");
                if (studentData.containsKey(fields[0])) {
                    String[] studentInfo = studentData.get(fields[0]);
                    writer.write(String.join(",", studentInfo) + "," + fields[1] + "," + fields[2] + "\n");
                }
            }
            System.out.println("Merged CSV saved successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}