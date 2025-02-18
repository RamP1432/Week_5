package com.tit.csvdatahandling.basicproblems;

import java.io.FileWriter;
import java.io.IOException;
import com.opencsv.CSVWriter;

public class Problem2 {
    public static void main(String[] args) {
        // File path of the CSV file
        String filePath = "C:\\Users\\patha\\OneDrive\\Desktop\\Week5_Day1\\src\\main\\resources\\CSV1.txt";

        // Try-with-resources to ensure CSVWriter is closed after use
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            // Header of the CSV file
            String[] sample = {"ID", "Name", "Department", "Salary"};
            writer.writeNext(sample);

            // Data rows to be written to the CSV file
            String[] data1 = {"100", "Amit", "HR", "90000"};
            writer.writeNext(data1);

            String[] data2 = {"101", "Ram", "IT", "80000"};
            writer.writeNext(data2);

            String[] data3 = {"102", "Raju", "Sales", "45000"};
            writer.writeNext(data3);

            String[] data4 = {"103", "Anish", "IT", "80000"};
            writer.writeNext(data4);

            String[] data5 = {"104", "Shushil", "Manager", "70000"};
            writer.writeNext(data5);
        } catch (IOException io) {
            // Print the exception message if an I/O error occurs
            System.out.println(io.getMessage());
        }
        // Confirm that the data was recorded successfully
        System.out.println("Data recorded successfully.");
    }
}
