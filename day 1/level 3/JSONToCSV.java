import java.io.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

public class JSONToCSV {
    public static void main(String[] args) {
        String jsonFile = "students4.json";
        String csvFile = "students4.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(jsonFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile))) {

            JSONArray jsonArray = new JSONArray(reader.readLine());
            writer.write("ID,Name,Age,Marks\n");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                writer.write(obj.getInt("ID") + "," + obj.getString("Name") + "," +
                             obj.getInt("Age") + "," + obj.getInt("Marks") + "\n");
            }
            System.out.println("CSV file created successfully!");
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }
}