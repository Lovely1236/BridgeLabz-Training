package com.example.json_practice.student;

public class Student {

    private String name;
    private int age;
    private String[] subjects;

    public Student(String name, int age, String[] subjects) {
        this.name = name;
        this.age = age;
        this.subjects = subjects;
    }

    // Convert Java Object -> JSON
    public String toJson() {

        StringBuffer sb = new StringBuffer();

        sb.append("{\n");
        sb.append("\"name\" : \"" + name + "\",\n");
        sb.append("\"age\" : " + age + ",\n");

        sb.append("\"subjects\" : [");

        for(int i = 0; i < subjects.length; i++) {

            sb.append("\"" + subjects[i] + "\"");

            if(i < subjects.length - 1)
                sb.append(", ");
        }

        sb.append("]\n");
        sb.append("}");

        return sb.toString();
    }
}
