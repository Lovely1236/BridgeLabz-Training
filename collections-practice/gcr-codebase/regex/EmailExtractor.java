package regex;
import java.util.*;
import java.util.regex.*;

public class EmailExtractor {

    public static void extractEmails(String text) {
        String regex="\\w+@\\w+\\.\\w+";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(text);
        boolean found=false;
        while(matcher.find()) {
            System.out.println(matcher.group());
            found=true;
        }

        if(!found) {
            System.out.println("No email addresses found");
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter text:");
        String text=sc.nextLine();

        extractEmails(text);
    }
}