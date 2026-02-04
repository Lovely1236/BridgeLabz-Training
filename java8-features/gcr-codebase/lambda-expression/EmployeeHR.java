package lambda_expression;
import java.util.*;
import java.util.stream.*;

public class EmployeeHR {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Lovely", "Mahima", "Palak");

        names.stream()
             .map(String::toUpperCase)
             .forEach(System.out::println);
    }
}
