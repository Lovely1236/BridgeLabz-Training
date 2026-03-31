package review;

import java.util.*;

public class LexicalTwist {
    static boolean isVowel(char ch) {
        return "AEIOUaeiou".indexOf(ch) != -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first word");
        String word1 = sc.nextLine();
        if (word1.trim().contains(" ")) {
            System.out.println(word1 + " is an invalid word");
            return;
        }
        System.out.println("Enter the second word");
        String word2 = sc.nextLine();
        if (word2.trim().contains(" ")) {
            System.out.println(word2 + " is an invalid word");
            return;
        }
        String revWord1 =new StringBuilder(word1).reverse().toString();

        if (revWord1.equalsIgnoreCase(word2)) {

            
            String result = revWord1.toLowerCase();
            result = result.replaceAll("[aeiou]", "@");
            System.out.println(result);

        } else { 	
            String combined = (word1 + word2).toUpperCase();

            int vowelCount = 0, consonantCount = 0;

            for (char ch : combined.toCharArray()) {
                if (ch >= 'A' && ch <= 'Z') {
                    if (isVowel(ch))
                        vowelCount++;
                    else
                        consonantCount++;
                }
            }

            
            if (vowelCount == consonantCount) {
                System.out.println("Vowels and consonants are equal");
                return;
            }

              Set<Character> set = new LinkedHashSet<>();

            for (char ch : combined.toCharArray()) {
                if (ch >= 'A' && ch <= 'Z') {
                    if (vowelCount > consonantCount && isVowel(ch)) {
                        set.add(ch);
                    } else if (consonantCount > vowelCount && !isVowel(ch)) {
                        set.add(ch);
                    }
                }
                if (set.size() == 2)
                    break;
            }

            // print result
            for (char ch : set) {
                System.out.print(ch);
            }
        }
    }
}
