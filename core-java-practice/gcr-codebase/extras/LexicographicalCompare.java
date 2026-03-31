import java.util.Scanner;

public class LexicographicalCompare{

    // Method to compare two strings lexicographically
    public static int compareStrings(String s1, String s2){

        int minLength = Math.min(s1.length(), s2.length());

        // Compare character by character
        for(int i = 0; i < minLength; i++){
            if(s1.charAt(i) != s2.charAt(i)){
                return s1.charAt(i) - s2.charAt(i);
            }
        }

        // If all characters matched, compare lengths
        return s1.length() - s2.length();
    }

    // MAIN METHOD



    public static void main(String[] args){


        Scanner sc = new Scanner(System.in);


        System.out.print("Enter first string: ");
        String str1 = sc.nextLine();
        System.out.print("Enter second string: ");
        String str2 = sc.nextLine();
        int result = compareStrings(str1, str2);
        if (result == 0) {
            System.out.println("Both strings are equal.");
        } else if (result < 0) {
            System.out.println("First string comes before second string.");
        } else {
            System.out.println("First string comes after second string.");
        }



        sc.close();
    }
}