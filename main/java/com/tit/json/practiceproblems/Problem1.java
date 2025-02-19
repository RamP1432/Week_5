package com.tit.json.practiceproblems;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

// Class representing a Student
class Student {
    String name;
    int age;
    String[] subjects;

    // Constructor to initialize Student object
    Student(String name, int age, String[] subjects) {
        this.name = name;
        this.age = age;
        this.subjects = subjects;
    }

    // Override toString method to print Student details
    @Override
    public String toString() {
        return "Name: " + name + " , Age: " + age + ", Subjects: " + Arrays.toString(subjects);
    }
}

public class Problem1 {
    public static void main(String[] args) {
        // Path to the JSON file where data will be stored
        String jsonFilePath = "C:\\Users\\patha\\OneDrive\\Desktop\\Week5_Day2\\src\\main\\resources\\JSONFile1.json";

        // Creating a list of Student objects
        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Rohan", 23, new String[]{"Math", "Science", "Computer", "English", "Hindi"}));
        studentList.add(new Student("Sanjay", 23, new String[]{"Math", "Science", "Computer", "English", "Hindi"}));
        studentList.add(new Student("Anuj", 23, new String[]{"Math", "Science", "Computer", "English", "Hindi"}));

        // Writing the list of Student objects to a JSON file
        try (FileWriter writer = new FileWriter(jsonFilePath)) {
            JSONArray jsonObjects = getJsonObject(studentList);
            writer.write(jsonObjects.toString(3)); // 3 is the indentation level for pretty printing
            System.out.println(jsonObjects.toString(3));
        } catch (IOException io) {
            System.out.println(io.getMessage());
        }
    }

    // Method to convert a list of Student objects to a JSONArray
    private static JSONArray getJsonObject(ArrayList<Student> list) {
        JSONArray jsonObjects = new JSONArray();

        // Loop through the list of Student objects
        for (Student student : list) {
            // Create a JSONObject for each Student
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("Name", student.name);
            jsonObject.put("Age", student.age);
            JSONArray jSubjects = new JSONArray(student.subjects);
            jsonObject.put("Subjects", jSubjects);

            // Add the JSONObject to the JSONArray
            jsonObjects.put(jsonObject);
        }
        return jsonObjects;
    }
}
