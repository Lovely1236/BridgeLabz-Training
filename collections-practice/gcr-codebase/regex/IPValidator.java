package regex;
import java.util.*;
public class IPValidator {
    public static boolean isValidIP(String ip) {
        String regex="^\\d{1,3}(\\.\\d{1,3}){3}$";
        return ip.matches(regex);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter IP address:");
        String ip=sc.nextLine();
        if(isValidIP(ip)) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}