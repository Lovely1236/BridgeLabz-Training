package regex;
import java.util.*;
public class SSNValidator{

    public static boolean isValidSSN(String ssn) {
        String regex="^\\d{3}-\\d{2}-\\d{4}$";
        return ssn.matches(regex);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter SSN:");
        String ssn=sc.nextLine();
        if(isValidSSN(ssn)) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}