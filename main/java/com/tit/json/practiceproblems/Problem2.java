package com.tit.json.practiceproblems;

import org.json.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// Class representing a Car
class Car {
    String model;
    double price;
    int maxSpeed;

    // Constructor to initialize Car object
    Car(String model, double price, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.price = price;
    }
}

public class Problem2 {
    public static void main(String[] args) {
        // Path to the JSON file where data will be stored
        String filePath = "C:\\Users\\patha\\OneDrive\\Desktop\\Week5_Day2\\src\\main\\resources\\JSONFile2.json";

        // Creating a Car object
        Car car1 = new Car("Toyota", 2220000, 300);

        // Convert Car object to JSON
        JSONObject carJson = getJsonObject(car1);

        // Write JSON to file
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(carJson.toString(3)); // 3 is the indentation level for pretty printing
        } catch (IOException io) {
            System.out.println(io.getMessage());
        }

        // Read JSON from file and print
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            StringBuilder jsonContent = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                jsonContent.append(line);
            }
            JSONObject carObject = new JSONObject(jsonContent.toString());
            System.out.println(carObject.toString(3)); // 3 is the indentation level for pretty printing
        } catch (IOException io) {
            System.out.println(io.getMessage());
        }
    }

    // Method to convert a Car object to a JSONObject
    private static JSONObject getJsonObject(Car car) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Model", car.model);
        jsonObject.put("Price", car.price);
        jsonObject.put("Max Speed", car.maxSpeed);
        return jsonObject;
    }
}
