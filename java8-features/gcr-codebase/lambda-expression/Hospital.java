package lambda_expression;
import java.util.*;

public class Hospital {
    public static void main(String[] args) {

        List<Integer> patientIds = Arrays.asList(1, 2, 3, 4);
        // Method reference
        patientIds.forEach(System.out::println);
    }
}
