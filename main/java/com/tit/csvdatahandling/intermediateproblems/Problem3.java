package com.tit.csvdatahandling.intermediateproblems;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Problem3 {
    public static void main(String[] args) {
        String filePath="C:\\Users\\patha\\OneDrive\\Desktop\\Week5_Day1\\src\\main\\resources\\CSV1.txt";
        ArrayList<String []> updatedDate=new ArrayList<>();
        try(CSVReader reader=new CSVReader(new FileReader(filePath))){
            String []line;
            updatedDate.add(reader.readNext());
            while((line=reader.readNext())!=null){
                if(line[2].equalsIgnoreCase("IT")){
                    line[3]=Double.toString(Math.floor(Double.parseDouble(line[3])*1.1));
                }
                updatedDate.add(line);
            }
            System.out.println(updatedDate);
        } catch (IOException io){
            System.out.println(io.getMessage());
        }
        try(CSVWriter writer=new CSVWriter(new FileWriter(filePath))){
            writer.writeAll(updatedDate);
        } catch (IOException io){
            System.out.println(io.getMessage());
        }
    }
}
