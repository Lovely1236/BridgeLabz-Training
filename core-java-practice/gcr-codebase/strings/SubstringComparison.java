import java.util.Scanner;

public class SubstringComparison{

    // Method to create substring using charAt()
    public static String substringWithCharAt(String str, int start, int end){

        String res = "";
        for(int i = start;i<end;i++){

            res += str.charAt(i);
        }
        return res;
    }

    // Method to compare two strings using charAt()
    public static boolean stringsCompareWithCharAt(String s1, String s2){
        if(s1.length()!= s2.length()){

            return false;

        }

        for(int i = 0;i< s1.length(); i++){

            if(s1.charAt(i) != s2.charAt(i)){

                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);    
        String str = sc.next();
        int begi = sc.nextInt();
        int end = sc.nextInt();



        // Substring using charAt()
        String resCharAt = substringWithCharAt(str, begi, end);


        // Substring using built-in method
        String resBuiltIn = str.substring(begi, end);

        // Compare both substrings
        boolean isSame = stringsCompareWithCharAt(resCharAt, resBuiltIn);


        // Display results
        System.out.println("Both substrings with CharAt  and substring with Built-In are equal? " + isSame);

        sc.close();
    }
}
