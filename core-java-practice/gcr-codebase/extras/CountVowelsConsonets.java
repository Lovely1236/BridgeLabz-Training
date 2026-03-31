import java.util.*;
public class CountVowelsConsonets{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String str = sc.next();// taking input from the user
    str.toLowerCase();
    int vowels = 0;
    int consonet = 0;
    for(int i = 0; i < str.length(); i++){    // run a loop and check for thte vowels and consonents.......
      char ch = str.charAt(i);
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
        vowels++;
      } 
      else{
        consonet++;
      }
    }



    // print the output
    System.out.println("The number of vowels -:" + vowels + " and the numeber of consonents are -:" + consonet);
    sc.close();
  }
}