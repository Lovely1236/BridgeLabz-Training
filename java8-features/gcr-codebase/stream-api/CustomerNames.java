package streamApi;

import java.util.*;

public class CustomerNames {
    public static void main(String[] args){
        List<String> names=List.of("parth","rahul","ankit","sneha");
        names.stream()
            .map(n->n.toUpperCase())
            .sorted()
            .forEach(System.out::println);
    }
}