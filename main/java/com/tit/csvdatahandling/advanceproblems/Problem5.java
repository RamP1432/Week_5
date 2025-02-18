package com.tit.csvdatahandling.advanceproblems;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem5 {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\patha\\OneDrive\\Desktop\\Week5_Day1\\src\\main\\resources\\CSV12.txt";

        // Map to store the records by ID
        Map<String,String[]> recordsMap = new HashMap<>();

        // List to store duplicate records
        List<String[]> duplicateRecords = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] line;
            reader.readNext(); // Skip header line

            while ((line = reader.readNext()) != null) {
                String id = line[0]; // Assuming ID is in the first column

                if (recordsMap.containsKey(id)) {
                    // If ID already exists, add the record to the list of duplicates
                    duplicateRecords.add(line);
                } else {
                    // If ID is new, add it to the map
                    recordsMap.put(id, line);
                }
            }
        } catch (IOException io) {
            System.out.println(io.getMessage());
        }

        // Print duplicate records
        System.out.println("Duplicate Records:");
        for (String[] record : duplicateRecords) {
            System.out.println(String.join(", ", record));
        }
    }
}
