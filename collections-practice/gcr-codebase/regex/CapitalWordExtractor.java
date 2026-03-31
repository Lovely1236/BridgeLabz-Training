package regex;
import java.util.*;
import java.util.regex.*;

public class CapitalWordExtractor {

    public static void extractWords(String text) {
        String regex="\\b[A-Z][a-z]*\\b";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(text);

        boolean found=false;

        while(matcher.find()) {
            System.out.println(matcher.group());
            found=true;
        }

        if(!found) {
            System.out.println("No capitalized words found");
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter text:");
        String text=sc.nextLine();
        extractWords(text);
    }
}