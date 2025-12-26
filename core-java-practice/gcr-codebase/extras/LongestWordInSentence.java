import java.util.*;
public class LongestWordInSentence {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // taking input from the user
    String str = sc.nextLine();
    String[] ch = str.split("[\\s,!.]+");
    int max = Integer.MIN_VALUE;
    String answer = "";

    // for loop
    
    
    
    for(int i = 0; i < ch.length; i++){
      max = Math.max(max, ch[i].length());
    }

    // for get the word......
    for(int i = 0; i < ch.length; i++){
      if(max == ch[i].length()){
        answer += ch[i];
        break;
      }
    }
    System.out.println(answer);
    sc.close();
  }
}