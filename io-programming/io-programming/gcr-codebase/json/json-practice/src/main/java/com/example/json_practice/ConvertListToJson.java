package com.example.json_practice;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Arrays;
import java.util.List;

public class ConvertListToJson {

    public static void main(String[] args) {

        try {

            List<Car> cars = Arrays.asList(
                    new Car("BMW", 5000000, "Black"),
                    new Car("Audi", 4500000, "White"),
                    new Car("Tesla", 6000000, "Red")
            );

            ObjectMapper mapper = new ObjectMapper();
            mapper.writerWithDefaultPrettyPrinter()
                    .writeValue(new File("cars.json"), cars);

            System.out.println(" JSON Array Created!");
            System.out.println("Location: "
                    + new File("cars.json").getAbsolutePath());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
