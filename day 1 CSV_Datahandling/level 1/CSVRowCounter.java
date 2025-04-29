import java.io.*;

public class CSVRowCounter {
    public static void main(String[] args) {
        String filePath = "students.csv";
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            reader.readLine(); // Skip header
            while (reader.readLine() != null) count++;
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Total records: " + count);
    }
}