package com.example.json_practice;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class ValidateJson {

    public static void main(String[] args) {

        String path = "user1.json"; 
        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.readTree(new File(path));

            System.out.println("JSON is VALID");

        } catch (Exception e) {

            System.out.println("Invalid JSON!");
            System.out.println("Error: " + e.getMessage());
        }
    }
}