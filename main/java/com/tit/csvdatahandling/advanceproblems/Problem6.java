package com.tit.csvdatahandling.advanceproblems;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Problem6{
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://127.0.0.1:3306/employeedata";
        String username = "root";
        String password = "MyDataBase";
        String csvFilePath = "C:\\Users\\patha\\OneDrive\\Desktop\\Week5_Day1\\src\\main\\resources\\CSV13.txt";

        // SQL query to fetch employee records
        String sql = "SELECT EmployeeID, Name, Department, Salary FROM employees";

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql);
             CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath))) {

            // Write header to the CSV file
            String[] header = {"Employee ID", "Name", "Department", "Salary"};
            writer.writeNext(header);

            // Write data to the CSV file
            while (resultSet.next()) {
                String employeeID = resultSet.getString("EmployeeID");
                String name = resultSet.getString("Name");
                String department = resultSet.getString("Department");
                String salary = resultSet.getString("Salary");

                String[] data = {employeeID, name, department, salary};
                writer.writeNext(data);
            }

            System.out.println("CSV report generated successfully.");

        } catch (SQLException | IOException sie) {
            System.out.println("Here some error please try to fix it.");
            System.out.println(sie.getMessage());
        }
    }
}
