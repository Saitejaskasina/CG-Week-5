import java.io.*;
import java.util.regex.*;

public class CSVValidator {
    public static void main(String[] args) {
        String filePath = "contacts.csv";
        Pattern emailPattern = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
        Pattern phonePattern = Pattern.compile("^\\d{10}$");

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String header = reader.readLine();
            System.out.println(header);
            
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                boolean isValidEmail = emailPattern.matcher(fields[2]).matches();
                boolean isValidPhone = phonePattern.matcher(fields[3]).matches();

                if (!isValidEmail || !isValidPhone) {
                    System.out.println("Invalid record: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}