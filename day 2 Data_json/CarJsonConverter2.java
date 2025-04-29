import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.*;
import java.io.IOException;

class Car2 {
    private String brand;
    private String model;
    private int year;

    public Car2(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    // Getters (needed for serialization)
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public int getYear() { return year; }
}

public class CarJsonConverter2 {
    public static void main(String[] args) {
        Car2 car = new Car2("Toyota", "Camry", 2022);
        ObjectMapper mapper = new ObjectMapper();
        String fileName = "car2.json"; // File to store JSON data

        try {
            String jsonString = mapper.writeValueAsString(car);
            Files.write(Paths.get(fileName), jsonString.getBytes());
            System.out.println("JSON saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}