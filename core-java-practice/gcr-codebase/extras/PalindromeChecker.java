import java.util.Scanner;
public class PalindromeChecker{
    public static String forInput(){    // Method to take string input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        return sc.nextLine();
    }
    public static boolean isPalindrome(String str){    // Method to check palindrome
        str = str.replaceAll("\\s+", "").toLowerCase();
        int beg = 0;
        int end = str.length() - 1;
        while(beg < end){
            if(str.charAt(beg)!=str.charAt(end)){
                return false;
            }
            beg++;
            end--;
        } return true;
    }
    public static void displayResult(String str, boolean result){     // Method to display result
        if(result){
            System.out.println("\"" + str + "\" is a PALINDROME");
        }
        else{
            System.out.println("\"" + str + "\" is NOT a palindrome");
        }
    }
    public static void main(String[] args){
        String input = forInput();
        boolean res = isPalindrome(input);
        displayResult(input, res);
    }
}
