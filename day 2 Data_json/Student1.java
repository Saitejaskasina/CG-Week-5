import org.json.JSONObject;
import org.json.JSONArray;
import java.nio.file.*;
import java.io.IOException;

public class Student1 {
    public static void main(String[] args) {
        JSONObject student = new JSONObject();
        student.put("name", "John Doe");
        student.put("age", 21);
        student.put("subjects", new JSONArray().put("Math").put("Physics").put("Computer Science"));

        String fileName = "students1.json"; // File to store JSON data

        try {
            Files.write(Paths.get(fileName), student.toString(4).getBytes());
            System.out.println("JSON saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}