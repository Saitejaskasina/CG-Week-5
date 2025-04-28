import java.io.*;
import java.util.*;

public class CSVDuplicateDetector {
    public static void main(String[] args) {
        String filePath = "students3.csv";
        Set<String> uniqueIds = new HashSet<>();
        List<String> duplicates = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String header = reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                String id = fields[0];

                if (!uniqueIds.add(id)) {
                    duplicates.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Duplicate records:");
        duplicates.forEach(System.out::println);
    }
}