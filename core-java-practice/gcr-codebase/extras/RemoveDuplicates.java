import java.util.*;

public class RemoveDuplicates{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    // taking input from the user
    String str = sc.next();
    String s = "";

    // loop
    for(int i = 0; i < str.length(); i++){
      char ch = str.charAt(i);
      if(!s.contains(String.valueOf(ch))){
        s += ch;
      } else {
        continue;
      }
    }
    System.out.println("New Updated String -:" + s);
    sc.close();
  }
}