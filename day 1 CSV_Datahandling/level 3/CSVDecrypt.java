import java.io.*;
import java.util.Base64;

public class CSVDecrypt {
    public static void main(String[] args) {
        String encryptedFile = "employees_encrypted.csv";
        String decryptedFile = "employees_decrypted.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(encryptedFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(decryptedFile))) {

            writer.write(reader.readLine() + "\n"); // Copy header
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                fields[2] = new String(Base64.getDecoder().decode(fields[2])); // Decrypt Email
                fields[3] = new String(Base64.getDecoder().decode(fields[3])); // Decrypt Salary
                writer.write(String.join(",", fields) + "\n");
            }
            System.out.println("Decrypted CSV file saved!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}