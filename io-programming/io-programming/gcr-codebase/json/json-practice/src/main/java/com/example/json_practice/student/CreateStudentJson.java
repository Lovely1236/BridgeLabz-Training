package com.example.json_practice.student;

import java.io.FileWriter;
import java.io.File;

public class CreateStudentJson {

    public static void main(String[] args) {

        try {

            Student student = new Student(
                    "Lovely",
                    22,
                    new String[]{"Java", "DBMS", "OS"}
            );

            // ✅ PATH (VERY SIMPLE)
            String path = "student.json";

            FileWriter writer = new FileWriter(path);

            writer.write(student.toJson());
            writer.close();

            System.out.println("✅ student.json created!");
            System.out.println("📌 File Location: "
                    + new File(path).getAbsolutePath());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
