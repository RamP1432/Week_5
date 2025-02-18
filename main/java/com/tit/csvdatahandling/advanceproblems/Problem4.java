package com.tit.csvdatahandling.advanceproblems;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Problem4 {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\patha\\OneDrive\\Desktop\\Week5_Day1\\src\\main\\resources\\CSV11.txt";
        int chunkSize = 100;
        int processedCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {

            for (CSVRecord record : csvParser) {
                // Process the record here
                // For demonstration, we just count the processed records
                processedCount++;
                if (processedCount % chunkSize == 0) {
                    System.out.println("Processed " + processedCount + " records.");
                }
            }

            // If there are remaining records that haven't been counted yet
            if (processedCount % chunkSize != 0) {
                System.out.println("Processed " + processedCount + " records.");
            }

        } catch (IOException io) {
            System.out.println(io.getMessage());        }
    }
}

