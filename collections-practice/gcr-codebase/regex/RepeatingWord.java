package regex;
import java.util.*;
import java.util.regex.*;
public class RepeatingWord{
    public static void findRepeats(String text) {
        String regex="\\b(\\w+)\\s+\\1\\b";
        Pattern pattern=Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
        Matcher matcher=pattern.matcher(text);
        boolean found=false;
        while(matcher.find()) {
            System.out.println(matcher.group(1));
            found=true;
        }

        if(!found) {
            System.out.println("No repeating words found");
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter sentence:");
        String text=sc.nextLine();
        findRepeats(text);
    }
}