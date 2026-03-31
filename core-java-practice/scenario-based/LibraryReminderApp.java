import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
public class LibraryReminderApp{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int totalFine = 0;
        System.out.println("Rohan  📚 WELCOME to Library Fine Calculator📚");
        for(int i=1;i<=5;i++){// Loop for 5 books
            System.out.println("\nBook " + i);
            System.out.print("Enter due date (yyyy-mm-dd): ");
            LocalDate dueDateee = LocalDate.parse(sc.next());
            System.out.print("Enter return date (yyyy-mm-dd): ");
            LocalDate returnDateee = LocalDate.parse(sc.next());
            if(returnDateee.isAfter(dueDateee)){  // Check if returned late
                long lateDays = ChronoUnit.DAYS.between(dueDateee, returnDateee);
                int fine = (int)lateDays * 5;
                totalFine += fine;
                System.out.println("Returned late by " + lateDays + " days");
                System.out.println("Fine for this book: ₹" + fine);
            } 
            else{
                System.out.println("Returned on time. No fine.");
            }
        }
        System.out.println("\nTotal Fine for all books: ₹" + totalFine);
        sc.close();
    }
}
