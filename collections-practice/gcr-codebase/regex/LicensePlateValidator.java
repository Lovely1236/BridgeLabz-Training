package regex;
import java.util.*;
public class LicensePlateValidator {

    public static boolean isValidPlate(String plate) {
        String regex="^[A-Z]{2}\\d{4}$";
        return plate.matches(regex);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter license plate number:");
        String plate=sc.nextLine();

        if(isValidPlate(plate)) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}