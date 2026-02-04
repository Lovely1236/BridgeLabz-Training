package com.example.json_practice;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadUserJson {

    public static void main(String[] args) {

        String path = "user.json";

        try {

            BufferedReader reader = new BufferedReader(new FileReader(path));

            String line;
            StringBuilder json = new StringBuilder();

            // Read full JSON
            while ((line = reader.readLine()) != null) {
                json.append(line);
            }

            reader.close();

            String jsonString = json.toString();

            // ✅ Extract specific fields manually
            String name = extractValue(jsonString, "name");
            String email = extractValue(jsonString, "email");

            System.out.println("Name  : " + name);
            System.out.println("Email : " + email);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to extract value
    private static String extractValue(String json, String key) {

        String searchKey = "\"" + key + "\"";
        int start = json.indexOf(searchKey);

        if (start == -1) return "Not Found";

        int colon = json.indexOf(":", start);
        int firstQuote = json.indexOf("\"", colon + 1);
        int secondQuote = json.indexOf("\"", firstQuote + 1);

        return json.substring(firstQuote + 1, secondQuote);
    }
}
