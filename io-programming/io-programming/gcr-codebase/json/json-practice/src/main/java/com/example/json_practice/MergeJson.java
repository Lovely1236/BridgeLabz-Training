package com.example.json_practice;

import java.io.*;

public class MergeJson {

    public static void main(String[] args) {

        try {

            String json1 = readFile("user1.json");
            String json2 = readFile("user2.json");

            // Remove closing brace from first JSON
            json1 = json1.trim().substring(0, json1.length() - 1);

            // Remove opening brace from second JSON
            json2 = json2.trim().substring(1);

            // Merge using StringBuffer
            StringBuffer merged = new StringBuffer();
            merged.append(json1);
            merged.append(",");
            merged.append(json2);

            // Write merged file
            FileWriter writer = new FileWriter("merged.json");
            writer.write(merged.toString());
            writer.close();

            System.out.println("✅ JSON Merged Successfully!");
            System.out.println("📌 Location: "
                    + new File("merged.json").getAbsolutePath());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to read file
    private static String readFile(String path) throws Exception {

        BufferedReader reader = new BufferedReader(new FileReader(path));

        StringBuilder sb = new StringBuilder();
        String line;

        while((line = reader.readLine()) != null){
            sb.append(line);
        }

        reader.close();
        return sb.toString();
    }
}
