package com.example.json_practice.car;

import java.io.FileWriter;
import java.io.File;

public class CreateCarJson {

    public static void main(String[] args) {

        try {

            Car car = new Car(
                    "BMW",
                    5000000,
                    "Black"
            );

            // ✅ SIMPLE PATH
            String path = "car.json";

            FileWriter writer = new FileWriter(path);

            writer.write(car.toJson());
            writer.close();

            System.out.println("✅ car.json created!");
            System.out.println("📌 File Location: "
                    + new File(path).getAbsolutePath());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
