import java.util.*;

public class Palindrome {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // taking string from the user
    String str = sc.next();
    String s = "";
    for(int i = str.length() - 1; i >= 0; i++){ // run a reverse loop
      s += str.charAt(i);
    }

    
    System.out.println(s.equals(str));// check whether both are equal or not
    sc.close();
  }
}