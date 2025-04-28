import java.io.*;

public class LargeCSVReader {
    public static void main(String[] args) {
        String filePath = "large_data.csv";
        int batchSize = 100;
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            reader.readLine(); // Skip header
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                count++;
                
                if (count % batchSize == 0) {
                    System.out.println("Processed " + count + " lines so far...");
                    Thread.sleep(500); // Simulating processing delay
                }
            }
            System.out.println("Total records processed: " + count);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}