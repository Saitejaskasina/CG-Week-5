import java.io.*;
import java.util.Arrays;

public class CSVReader {
    public static void main(String[] args) {
        String filePath = "students.csv";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(Arrays.toString(line.split(",")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}