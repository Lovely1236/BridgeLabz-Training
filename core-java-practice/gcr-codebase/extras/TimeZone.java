import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.util.Scanner;

public class TimeZone{
       public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Time Zone Converter...Here are your options to choose from: ");
        System.out.println("1. GMT");
        System.out.println("2. IST");
        System.out.println("3. PST");
        int choice = sc.nextInt();
        ZonedDateTime time;

        switch(choice){
            case 1:
                time = ZonedDateTime.now(ZoneId.of("GMT"));
                System.out.println("Current GMT Time: " + time);
                break;

            case 2:
                time = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
                System.out.println("Current IST Time: " + time);
                break;

            case 3:
                time = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));
                System.out.println("Current PST Time: " + time);
                break;

            default:
                System.out.println("Invalid Choice");
        }

        sc.close();
    }
}
