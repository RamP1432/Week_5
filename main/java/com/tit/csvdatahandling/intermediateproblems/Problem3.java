package com.tit.csvdatahandling.intermediateproblems;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Problem3 {
    public static void main(String[] args) {
        // Specify the path to the CSV file
        String filePath = "C:\\Users\\patha\\OneDrive\\Desktop\\Week5_Day1\\src\\main\\resources\\CSV1.txt";
        // List to store updated records
        ArrayList<String[]> updatedData = new ArrayList<>();

        // Read the CSV file
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] line;
            // Read and add the header row
            updatedData.add(reader.readNext());
            while ((line = reader.readNext()) != null) {
                // Check if the department is "IT"
                if (line[2].equalsIgnoreCase("IT")) {
                    // Increase the salary by 10% and round it down to the nearest integer
                    line[3] = Double.toString(Math.floor(Double.parseDouble(line[3]) * 1.1));
                }
                // Add the updated line to the list
                updatedData.add(line);
            }
        } catch (IOException io) {
            // Handle any IO exceptions that occur
            System.out.println(io.getMessage());
        }

        // Write the updated records back to the same CSV file
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            writer.writeAll(updatedData);
        } catch (IOException io) {
            // Handle any IO exceptions that occur
            System.out.println(io.getMessage());
        }
    }
}
