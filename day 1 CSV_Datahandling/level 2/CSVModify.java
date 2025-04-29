import java.io.*;
import java.util.*;

public class CSVModify {
    public static void main(String[] args) {
        String filePath = "employees.csv";
        List<String> updatedRecords = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String header = reader.readLine();
            updatedRecords.add(header);

            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields[2].equalsIgnoreCase("IT")) {
                    fields[3] = String.valueOf(Integer.parseInt(fields[3]) * 1.1); // 10% increase
                }
                updatedRecords.add(String.join(",", fields));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("updated_employees.csv"))) {
            for (String record : updatedRecords) writer.write(record + "\n");
            System.out.println("Updated CSV saved successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}