package com.tit.json.practiceproblems;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Problem7 {
    public static void main(String[] args) {
        // Path to your JSON file
        File jsonFile=new File("C:\\Users\\patha\\OneDrive\\Desktop\\Week5_Day2\\src\\main\\resources\\JSONFile7.json");
        // Create an ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Parse the JSON file into a JsonNode
            JsonNode rootNode = objectMapper.readTree(jsonFile);

            // Check if the root node is an array
            if (rootNode.isArray()) {
                System.out.println("Filtered records (age > 25):");
                // Iterate through each element in the array
                for (JsonNode personNode : rootNode) {
                    // Check if the record has an "age" field and if it's > 25
                    if (personNode.has("Age") && personNode.get("Age").asInt() > 25) {
                        // Print the filtered JSON record (pretty printed)
                        String person = objectMapper.writerWithDefaultPrettyPrinter()
                                .writeValueAsString(personNode);
                        System.out.println(person);
                    }
                }
            } else {
                System.err.println("Expected a JSON array.");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}