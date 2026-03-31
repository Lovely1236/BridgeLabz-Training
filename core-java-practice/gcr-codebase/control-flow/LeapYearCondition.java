import java.util.*;

public class LeapYearCondition{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter year: ");

        int year = sc.nextInt();

        if (year >= 1582 && (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))) {

            System.out.println("Year is a Leap Year");
        } 
        else if (year < 1582) {
            System.out.println("Leap Year calculation is valid only for year >= 1582");
        } 
        else {
            System.out.println("Year is not a Leap Year");
        }

        sc.close();
    }
}
