package regex;
import java.util.*;
import java.util.regex.*;

public class LinkExtractor {

    public static void extractLinks(String text) {
        String regex="https?://\\S+";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(text);

        boolean found=false;

        while(matcher.find()) {
            System.out.println(matcher.group());
            found=true;
        }

        if(!found) {
            System.out.println("No links found");
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter text:");
        String text=sc.nextLine();
        extractLinks(text);
    }
}