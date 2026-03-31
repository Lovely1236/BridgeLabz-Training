package regex;
import java.util.*;
import java.util.regex.*;
public class LanguageExtractor {

    public static void extractLanguages(String text) {
        String regex="\\b(Java|Python|JavaScript|Go)\\b";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(text);
        boolean found=false;
        while(matcher.find()) {
            System.out.println(matcher.group());
            found=true;
        }

        if(!found) {
            System.out.println("No languages found");
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter text:");
        String text=sc.nextLine();
        extractLanguages(text);
    }
}