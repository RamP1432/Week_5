package com.tit.csvdatahandling.basicproblems;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;

public class Problem3 {
    public static void main(String[] args) {
        // Variable to count the number of rows
        int countRow = 0;
        // File path of the CSV file
        String filePath = "C:\\Users\\patha\\OneDrive\\Desktop\\Week5_Day1\\src\\main\\resources\\CSV1.txt";

        // Try-with-resources to ensure CSVReader is closed after use
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            // Read each line of the CSV file and count the number of rows
            while (reader.readNext() != null) {
                countRow++;
            }
            // Print the total number of rows
            System.out.println("Number of Rows : " + countRow);
        } catch (IOException io) {
            // Print the exception message if an I/O error occurs
            System.out.println(io.getMessage());
        }
    }
}
