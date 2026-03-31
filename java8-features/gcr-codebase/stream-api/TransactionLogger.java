package streamApi;
import java.time.*;
import java.util.*;

public class TransactionLogger {
    public static void main(String[] args){
        List<String> transactionIds=List.of("TXN101","TXN102","TXN103");
        transactionIds.forEach(id->
            System.out.println(LocalDateTime.now()+"-Transaction:"+id)
        );
    }
}