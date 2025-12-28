import java.time.LocalDate;
import java.util.Scanner;
public class DateArithmetic{
    public static void main(String[] args){
          Scanner sc = new Scanner(System.in);
          System.out.print("Welcome to Date Arithmetic....Enter date (yyyy-mm-dd): "); // Take date input
        String inputDate = sc.nextLine();
        LocalDate date = LocalDate.parse(inputDate);

        
        // Add 7 days, 1 month, and 2 years
        
        LocalDate updatedDate = date
                .plusDays(7)
                .plusMonths(1)
                .plusYears(2);
        
        updatedDate = updatedDate.minusWeeks(3);// Subtract 3 weeks
        System.out.println("Final Date after calculations: " + updatedDate);// Display result
        sc.close();
    }
}
