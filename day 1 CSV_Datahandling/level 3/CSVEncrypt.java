import java.io.*;
import java.util.Base64;

public class CSVEncrypt {
    public static void main(String[] args) {
        String filePath = "employees.csv";
        String encryptedFile = "employees_encrypted.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(encryptedFile))) {

            writer.write(reader.readLine() + "\n"); // Copy header
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                fields[2] = Base64.getEncoder().encodeToString(fields[2].getBytes()); // Encrypt Email
                fields[3] = Base64.getEncoder().encodeToString(fields[3].getBytes()); // Encrypt Salary
                writer.write(String.join(",", fields) + "\n");
            }
            System.out.println("Encrypted CSV file saved!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}