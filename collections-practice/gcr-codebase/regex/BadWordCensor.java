package regex;
import java.util.*;
public class BadWordCensor {
    public static String censorText(String text,String[] badWords) {
        for(String word:badWords) {
            String regex="\\b"+word+"\\b";
            text=text.replaceAll(regex,"****");
        }
        return text;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter sentence:");
        String text=sc.nextLine();
        String[] badWords={"damn","stupid"};
        String result=censorText(text,badWords);
        System.out.println(result);
    }
}