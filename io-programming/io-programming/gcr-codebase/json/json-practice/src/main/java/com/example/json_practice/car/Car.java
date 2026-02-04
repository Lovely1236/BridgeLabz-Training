package com.example.json_practice.car;

public class Car {

    private String brand;
    private int price;
    private String color;

    public Car(String brand, int price, String color) {
        this.brand = brand;
        this.price = price;
        this.color = color;
    }

    // Convert Java Object -> JSON
    public String toJson() {

        StringBuffer sb = new StringBuffer();

        sb.append("{\n");
        sb.append("\"brand\" : \"" + brand + "\",\n");
        sb.append("\"price\" : " + price + ",\n");
        sb.append("\"color\" : \"" + color + "\"\n");
        sb.append("}");

        return sb.toString();
    }
}
