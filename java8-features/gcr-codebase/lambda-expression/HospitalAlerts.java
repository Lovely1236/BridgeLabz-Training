package lambda_expression;
import java.util.*;
import java.util.function.Predicate;

class Alert {
    String message;
    String severity; 

    Alert(String message, String severity) {
        this.message = message;
        this.severity = severity;
    }

    public String toString() {
        return severity + " → " + message;
    }
}

public class HospitalAlerts {
    public static void main(String[] args) {

        List<Alert> alerts = Arrays.asList(
                new Alert("Heart rate abnormal", "HIGH"),
                new Alert("Medicine reminder", "LOW"),
                new Alert("BP slightly high", "MEDIUM")
        );

        Predicate<Alert> highOnly = alert -> 
                alert.severity.equals("HIGH");

        alerts.stream()
              .filter(highOnly)
              .forEach(System.out::println);
    }
}
