package regex;
import java.util.*;
public class CardValidator {
    public static boolean isValidCard(String card) {
        String regex="^(4\\d{15}|5\\d{15})$";
        return card.matches(regex);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter card number:");
        String card=sc.nextLine();
        if(isValidCard(card)) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}