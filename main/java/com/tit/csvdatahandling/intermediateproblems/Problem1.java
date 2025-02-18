package com.tit.csvdatahandling.intermediateproblems;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Problem1 {
    public static void main(String[] args) {
        // Defining the file path to the CSV file
        String filePath="C:\\Users\\patha\\OneDrive\\Desktop\\Week5_Day1\\src\\main\\resources\\CSV2.txt";

        // Using try-with-resources to ensure the CSVReader is closed automatically
        try(CSVReader reader = new CSVReader(new FileReader(filePath))){
            String []line; // Array to store each line read from the CSV file
            reader.readNext(); // Skipping the header row

            // Reading lines until the end of the file
            while((line=reader.readNext())!=null){
                // Parsing the third column value to an integer and checking if it's greater than 80
                if(Integer.parseInt(line[2])>80){
                    // Printing the entire line if the third column value is greater than 80
                    System.out.println(Arrays.toString(line));
                }
            }
        } catch (IOException io){
            // Printing the exception message in case of an input-output error
            System.out.println(io.getMessage());
        }
    }
}
