import java.io.*;

public class CSVWriter {
    public static void main(String[] args) {
        String filePath = "employees.csv";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("ID,Name,Department,Salary\n");
            writer.write("201,Mike,HR,50000\n");
            writer.write("202,Jane,IT,60000\n");
            writer.write("203,Robert,Finance,55000\n");
            writer.write("204,Emily,IT,65000\n");
            writer.write("205,Tom,Marketing,48000\n");
            System.out.println("CSV file written successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}