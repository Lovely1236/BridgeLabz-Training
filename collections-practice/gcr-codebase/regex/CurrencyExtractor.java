package regex;
import java.util.*;
import java.util.regex.*;
public class CurrencyExtractor {

    public static void extractCurrency(String text) {
        String regex="\\$?\\d+(\\.\\d+)?";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(text);

        boolean found=false;

        while(matcher.find()) {
            System.out.println(matcher.group());
            found=true;
        }

        if(!found) {
            System.out.println("No currency found");
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter text:");
        String text=sc.nextLine();
        extractCurrency(text);
    }
}