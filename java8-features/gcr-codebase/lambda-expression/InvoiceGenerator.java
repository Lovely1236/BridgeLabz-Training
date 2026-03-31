package lambda_expression;
import java.util.*;
import java.util.stream.*;

class Invoice {

    int transactionId;

    Invoice(int transactionId) {
        this.transactionId = transactionId;
    }

    public String toString() {
        return "Invoice for Transaction: " + transactionId;
    }
}

public class InvoiceGenerator {
    public static void main(String[] args) {

        List<Integer> transactionIds = Arrays.asList(501, 502, 503);

        List<Invoice> invoices =
                transactionIds.stream()
                              .map(Invoice::new) 
                              .collect(Collectors.toList());

        invoices.forEach(System.out::println);
    }
}
