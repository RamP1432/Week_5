package com.tit.json.practiceproblems;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

import java.io.File;
import java.io.IOException;

public class Problem5 {
    public static void main(String[] args) throws IOException, ProcessingException {
        ObjectMapper mapper=new ObjectMapper();
        JsonNode schemaNode=mapper.readTree(new File("C:\\Users\\patha\\OneDrive\\Desktop\\Week5_Day2\\src\\main\\resources\\JSON4merged.json"));
        JsonSchemaFactory factory=JsonSchemaFactory.byDefault();
        JsonSchema schema=factory.getJsonSchema(schemaNode);
        //load json file
        JsonNode jsonNode=mapper.readTree(new File("C:\\Users\\patha\\OneDrive\\Desktop\\Week5_Day2\\src\\main\\resources\\JSONFile5.json"));
        //validate JsonNode
        if(schema.validate(jsonNode).isSuccess()){
            System.out.println("Validated successfully.");
        }
        else{
            System.out.println("Not validated.");
        }
    }
}
