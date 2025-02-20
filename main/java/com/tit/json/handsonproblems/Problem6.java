package com.tit.json.handsonproblems;

import org.json.JSONObject;
import org.json.XML;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Problem6 {

    public static void main(String[] args) {
        try {
            // Read JSON file content as a String
            String jsonFilePath = "C:\\Users\\patha\\OneDrive\\Desktop\\Week5_Day2\\src\\main\\resources\\JSONFile6.json";
            String jsonContent = new String(Files.readAllBytes(Paths.get(jsonFilePath)), StandardCharsets.UTF_8);

            // Convert JSON String to JSONObject
            JSONObject jsonObject = new JSONObject(jsonContent);

            // Convert JSONObject to XML String
            String xmlContent = XML.toString(jsonObject);

            // Optionally, add a root element if needed:

            // Write the XML String to a file
            String xmlFilePath ="C:\\Users\\patha\\OneDrive\\Desktop\\Week5_Day2\\src\\main\\resources\\XML6.xml";
            Files.write(Paths.get(xmlFilePath), xmlContent.getBytes(StandardCharsets.UTF_8));

            System.out.println("XML conversion completed. Check the file: " + xmlFilePath);
        } catch (Exception e) {
            System.out.println(e.getMessage());        }
    }
}