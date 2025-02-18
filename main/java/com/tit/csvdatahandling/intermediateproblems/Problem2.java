package com.tit.csvdatahandling.intermediateproblems;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Problem2 {
    public static void main(String[] args) {
        // Specify the path to the CSV file
        String filePath = "C:\\Users\\patha\\OneDrive\\Desktop\\Week5_Day1\\src\\main\\resources\\CSV1.txt";
        // Specify the employee name to search for
        String empName = "Anish";

        // Use try-with-resources to ensure the reader is closed after operations are done
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] line;
            // Read the file line by line
            while ((line = reader.readNext()) != null) {
                // Check if the second element in the line matches the employee name
                if (line[1].equals(empName)) {
                    // Print the line as a string array if a match is found
                    System.out.println(Arrays.toString(line));
                }
            }
        } catch (IOException io) {
            // Handle any IO exceptions that occur
            System.out.println(io.getMessage());
        }
    }
}
