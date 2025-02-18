package com.tit.csvdatahandling.intermediateproblems;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Problem4 {
    public static void main(String[] args) {
        // Specify the path to the CSV file
        String filePath = "C:\\Users\\patha\\OneDrive\\Desktop\\Week5_Day1\\src\\main\\resources\\CSV1.txt";
        // List to store the CSV data
        List<String[]> list = new ArrayList<>();

        // Read the CSV file
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] line;
            // Skip the header row
            reader.readNext();
            // Read the file line by line and add each line to the list
            while ((line = reader.readNext()) != null) {
                list.add(line);
            }
        } catch (IOException io) {
            // Handle any IO exceptions that occur
            System.out.println(io.getMessage());
        }

        // Sort the list based on the element at index 3 (salary) in descending order using a lambda expression
        list.sort((o1, o2) -> Double.compare(Double.parseDouble(o2[3]), Double.parseDouble(o1[3])));

        // Print the top 5 records
        for (int i = 0; i < 5 && i < list.size(); i++) {
            System.out.println(Arrays.toString(list.get(i)));
        }
    }
}
