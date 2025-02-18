package com.tit.csvdatahandling.advanceproblems;

// Importing the necessary libraries
import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Define the Student class
class Student{
    // Attributes of a student
    int rollNumber;
    String name;
    double mark;

    // Constructor to initialize a student object
    Student(int rollNumber, String name, double mark){
        this.name = name;
        this.mark = mark;
        this.rollNumber = rollNumber;
    }

    // Override the toString() method to display student details
    public String toString(){
        return "Roll Number: " + rollNumber + " , Name: " + name + " , Marks: " + mark;
    }
}

public class Problem2 {
    public static void main(String[] args) {
        // Path to the CSV file
        String filePath = "C:\\Users\\patha\\OneDrive\\Desktop\\Week5_Day1\\src\\main\\resources\\CSV9.txt";

        // List to store Student objects
        List<Student> studentList = new ArrayList<>();

        // Try-with-resources statement to ensure the reader is closed automatically
        try(CSVReader reader = new CSVReader(new FileReader(filePath))){
            // Skip the header line
            reader.readNext();
            String []line;

            // Read each line from the CSV file
            while((line = reader.readNext()) != null){
                // Create a new Student object and add it to the list
                studentList.add(new Student(Integer.parseInt(line[0]), line[1], Double.parseDouble(line[2])));
            }
        } catch (IOException io){
            // Handle potential IOExceptions
            System.out.println(io.getMessage());
        }

        // Print the details of each student
        for(Student student : studentList){
            System.out.println(student);
        }
    }
}
