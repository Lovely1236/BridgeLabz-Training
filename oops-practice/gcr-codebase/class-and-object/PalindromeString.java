import java.util.*;
class PalindromeChecker{
    String text;
    void takeInput(Scanner ob){
        System.out.println("Enter text");
        text = ob.nextLine();
    }
    boolean isPalindrome(){
        String cleanedText = text.replaceAll("\\s+", "").toLowerCase();
        int start = 0;
        int end = cleanedText.length()-1;
        while (start < end){
            if (cleanedText.charAt(start) != cleanedText.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    void displayResult(){
        if(isPalindrome()){
            System.out.println(text+" is palindrome");
        } 
        else{
            System.out.println(text+" is not Palindrome");
        }
    }
}
public class PalindromeString{
    public static void main(String[] args){
        Scanner ob = new Scanner(System.in);
        System.out.print("Enter number of strings: ");
        int count = ob.nextInt();
        for(int i=1;i<=count;i++){
            PalindromeChecker checker = new PalindromeChecker();
            checker.takeInput(ob);
            checker.displayResult();
        }
    }
}