package regex;
import java.util.*;

public class ValidateUsername {

    public static boolean isValidUsername(String username) {
        String regex="^[A-Za-z]\\w{4,14}$";
        return username.matches(regex);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter username:");
        String username=sc.nextLine();
        if(isValidUsername(username)) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}