package regex;
import java.util.*;
public class HexColorValidator {
    public static boolean isValidHex(String color) {
        String regex="^#[0-9A-Fa-f]{6}$";
        return color.matches(regex);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter hex color code:");
        String color=sc.nextLine();
        if(isValidHex(color)) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}