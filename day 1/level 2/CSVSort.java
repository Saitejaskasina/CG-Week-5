import java.io.*;
import java.util.*;

public class CSVSort {
    public static void main(String[] args) {
        String filePath = "employees.csv";
        List<String[]> employees = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String header = reader.readLine(); // Store header
            String line;
            while ((line = reader.readLine()) != null) {
                employees.add(line.split(","));
            }

            employees.sort((a, b) -> Integer.parseInt(b[3]) - Integer.parseInt(a[3])); // Descending order

            System.out.println(header); // Print header
            for (int i = 0; i < Math.min(5, employees.size()); i++) {
                System.out.println(String.join(",", employees.get(i))); // Print top 5
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}