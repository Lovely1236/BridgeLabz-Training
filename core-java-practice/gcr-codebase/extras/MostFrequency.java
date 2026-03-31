import java.util.*;

public class MostFrequency{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    // taking input from the user
    String str = sc.next();
    int count = 1;
    char ch = ' ';
    int max = Integer.MIN_VALUE;
    // run a double loop and use two pointer approach to solve this
    for(int i = 0; i < str.length(); i++){
      for(int j = i + 1; j < str.length(); j++){
        if(str.charAt(i) == str.charAt(j)){
          count++;
        }
      }
      if(count > max){
        max = count;
        ch = str.charAt(i);
      }
    }
    System.out.println("The maximum frequency is -:" + max + " and the char is -:" + ch);
    sc.close();
  }
}