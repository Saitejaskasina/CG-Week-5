import java.io.*;

public class CSVFilter {
    public static void main(String[] args) {
        String filePath = "students.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            reader.readLine(); // Skip header
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                int marks = Integer.parseInt(fields[3]);
                if (marks > 80) System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}