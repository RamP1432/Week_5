package com.tit.json.handsonproblems;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

public class Problem5{
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper=new ObjectMapper();
        JsonNode node1=objectMapper.readTree(new File("C:\\Users\\patha\\OneDrive\\Desktop\\Week5_Day2\\src\\main\\resources\\JSON4.0.json"));
        JsonNode node2=objectMapper.readTree(new File("C:\\Users\\patha\\OneDrive\\Desktop\\Week5_Day2\\src\\main\\resources\\JSON4.1.json"));
        ObjectNode mergedNode = (ObjectNode) node1;
        mergedNode.setAll((ObjectNode) node2);
        // Print or save the merged JSON
        System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(mergedNode));
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("C:\\Users\\patha\\OneDrive\\Desktop\\Week5_Day2\\src\\main\\resources\\JSON4merged.json"),mergedNode);

    }
}
