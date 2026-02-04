package com.example.json_practice;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterJsonByAge {

    public static void main(String[] args) {

        try {

            ObjectMapper mapper = new ObjectMapper();

           
            Person[] peopleArray =
                    mapper.readValue(new File("people.json"), Person[].class);

            
            List<Person> people = Arrays.asList(peopleArray);

           
            List<Person> filtered =
                    people.stream()
                            .filter(p -> p.getAge() > 25)
                            .collect(Collectors.toList());

           
            filtered.forEach(p ->
                    System.out.println(p.getName() + " : " + p.getAge()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
