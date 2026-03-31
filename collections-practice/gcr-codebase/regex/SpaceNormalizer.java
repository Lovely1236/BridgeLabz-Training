package regex;
import java.util.*;
public class SpaceNormalizer {
    public static String normalizeSpaces(String text) {
        return text.replaceAll("\\s+"," ").trim();
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter text:");
        String text=sc.nextLine();
        String result=normalizeSpaces(text);
        System.out.println(result);
    }
}