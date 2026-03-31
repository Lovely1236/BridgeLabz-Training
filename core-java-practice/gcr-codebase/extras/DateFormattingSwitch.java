import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class DateFormattingSwitch{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        LocalDate today = LocalDate.now();
        System.out.println("Welcome to Date Formatting...Here are your choices of Date Format to choose from:");
        System.out.println("1. dd/MM/yyyy");
        System.out.println("2. yyyy-MM-dd");
        System.out.println("3. EEE, MMM dd, yyyy");
        int choice = sc.nextInt();
        DateTimeFormatter formatter;

        switch (choice){
            case 1:
                formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                System.out.println("Formatted Date: " + today.format(formatter));
                break;
            case 2:
                formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                System.out.println("Formatted Date: " + today.format(formatter));
                break;
            case 3:
                formatter = DateTimeFormatter.ofPattern("EEE, MMM dd, yyyy");
                System.out.println("Formatted Date: " + today.format(formatter));
                break;
            default:
                System.out.println("Invalid Choice");
        } sc.close();
    }
}
