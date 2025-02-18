package com.tit.csvdatahandling.advanceproblems;

// Importing necessary libraries
import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Problem1 {
    public static void main(String[] args) {
        // Path to the CSV file
        String filePath="C:\\Users\\patha\\OneDrive\\Desktop\\Week5_Day1\\src\\main\\resources\\CSV8.txt";

        // Try-with-resources statement to ensure the reader is closed automatically
        try(CSVReader reader=new CSVReader(new FileReader(filePath))){
            // Skip the header line
            reader.readNext();
            String []line;

            // Read each line from the CSV file
            while((line= reader.readNext())!=null){
                // Extract phone number and email from the current line
                String phoneNumber=line[3];
                String email=line[2];

                // Regular expression validators for phone number and email
                String phoneValidator="^\\d{10}$";
                String emailValidator="^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

                // Validate the phone number and email, and print the line if either is invalid
                if(!Pattern.matches(phoneValidator,phoneNumber)){
                    System.out.println("This is not correct Data: error");
                    System.out.println(Arrays.toString(line));
                }else if(!Pattern.matches(emailValidator,email)){
                    System.out.println("This is not correct Data: error");
                    System.out.println(Arrays.toString(line));
                }
            }
        }catch (IOException io){
            // Handle potential IOExceptions
            System.out.println(io.getMessage());
        }
    }
}
