package com.tit.csvdatahandling.basicproblems;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;

public class Problem1 {
    public static void main(String[] args) {
        // File path of the CSV file
        String filePath = "C:\\Users\\patha\\OneDrive\\Desktop\\Week5_Day1\\src\\main\\resources\\CSV1.txt";

        // Try-with-resources to ensure CSVReader is closed after use
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] line;

            // Read each line of the CSV file
            while ((line = reader.readNext()) != null) {
                // Print each data value in the line
                for (String data : line) {
                    System.out.print(data + " ");
                }
                // Print a new line after each CSV line
                System.out.println();
            }
        } catch (IOException io) {
            // Print the exception message if an I/O error occurs
            System.out.println(io.getMessage());
        }
    }
}
