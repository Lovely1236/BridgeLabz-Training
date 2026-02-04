package com.example.json_practice;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.Iterator;
import java.util.Map;

public class ReadAllJsonKeys {

    public static void main(String[] args) {

        try {

            ObjectMapper mapper = new ObjectMapper();

            JsonNode node = mapper.readTree(new File("user1.json"));

            Iterator<Map.Entry<String, JsonNode>> fields = node.fields();

            while(fields.hasNext()) {

                Map.Entry<String, JsonNode> entry = fields.next();

                String key = entry.getKey();
                JsonNode value = entry.getValue();

                System.out.println(key + " : " + value);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
