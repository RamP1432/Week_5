package com.tit.csvdatahandling.advanceproblems;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class Problem7 {
    public static void main(String[] args) {
        String jsonFilePath = "C:\\Users\\patha\\OneDrive\\Desktop\\Week5_Day1\\src\\main\\resources\\JSON14.json";
        String csvFilePath = "C:\\Users\\patha\\OneDrive\\Desktop\\Week5_Day1\\src\\main\\resources\\CSV14.txt";

        try (CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath))) {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new FileReader(jsonFilePath));

            // Assuming the JSON structure is an array of students
            if (rootNode.isArray()) {
                Iterator<JsonNode> elements = rootNode.elements();
                boolean headerWritten = false;

                while (elements.hasNext()) {
                    JsonNode studentNode = elements.next();
                    Iterator<Map.Entry<String, JsonNode>> fields = studentNode.fields();

                    if (!headerWritten) {
                        // Write header
                        String[] header = new String[studentNode.size()];
                        int index = 0;
                        while (fields.hasNext()) {
                            Map.Entry<String, JsonNode> field = fields.next();
                            header[index++] = field.getKey();
                        }
                        writer.writeNext(header);
                        fields = studentNode.fields(); // Reset fields iterator
                        headerWritten = true;
                    }

                    // Write student data
                    String[] data = new String[studentNode.size()];
                    int index = 0;
                    while (fields.hasNext()) {
                        Map.Entry<String, JsonNode> field = fields.next();
                        data[index++] = field.getValue().asText();
                    }
                    writer.writeNext(data);
                }
            }

            System.out.println("JSON to CSV conversion completed successfully.");
        } catch (IOException io) {
            System.out.println(io.getMessage());        }
    }
}
