package com.tit.csvdatahandling.advanceproblems;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Problem3 {
    public static void main(String[] args) {
        String file1Path = "C:\\Users\\patha\\OneDrive\\Desktop\\Week5_Day1\\src\\main\\resources\\CSV10file1.txt";
        String file2Path = "C:\\Users\\patha\\OneDrive\\Desktop\\Week5_Day1\\src\\main\\resources\\CSV10file2.txt";
        String outputFilePath = "C:\\Users\\patha\\OneDrive\\Desktop\\Week5_Day1\\src\\main\\resources\\CSV10output.txt";

        // Maps to store data from CSV files
        Map<String, String[]> students1Data = new HashMap<>();
        Map<String, String[]> students2Data = new HashMap<>();

        // Read data from students1.csv
        try (CSVReader reader = new CSVReader(new FileReader(file1Path))) {
            String[] line;
            reader.readNext(); // Skip header line
            while ((line = reader.readNext()) != null) {
                students1Data.put(line[0], line);
            }
        } catch (IOException io) {
            System.out.println(io.getMessage());
        }

        // Read data from students2.csv
        try (CSVReader reader = new CSVReader(new FileReader(file2Path))) {
            String[] line;
            reader.readNext(); // Skip header line
            while ((line = reader.readNext()) != null) {
                students2Data.put(line[0], line);
            }
        } catch (IOException io) {
            System.out.println(io.getMessage());
        }

        // Write merged data to a new CSV file
        try (CSVWriter writer = new CSVWriter(new FileWriter(outputFilePath))) {
            // Write header
            writer.writeNext(new String[] {"ID", "Name", "Age", "Marks", "Grade"});

            // Merge data and write to the output file
            for (String id : students1Data.keySet()) {
                String[] student1 = students1Data.get(id);
                String[] student2 = students2Data.get(id);
                if (student2 != null && student1 != null) {
                    writer.writeNext(new String[] {id, student1[1], student1[2], student2[1], student2[2]});
                }
            }
        } catch (IOException io) {
            System.out.println(io.getMessage());
        }

        System.out.println("CSV files merged successfully!");
    }
}

