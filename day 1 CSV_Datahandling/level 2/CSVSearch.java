import java.io.*;

public class CSVSearch {
    public static void main(String[] args) {
        String filePath = "employees.csv";
        String searchName = "Emily";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            reader.readLine(); // Skip header
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields[1].equalsIgnoreCase(searchName)) {
                    System.out.println("Department: " + fields[2] + ", Salary: " + fields[3]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}