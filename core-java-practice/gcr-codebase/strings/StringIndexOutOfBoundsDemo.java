import java.util.*;

public class StringIndexOutOfBoundsDemo{

  public static void generateException(String str){

    for(int i = 0;i<str.length() + 1;i++){
      System.out.println(str.charAt(i));
    }
  }

  public static void handleIndexOutOfBounds(String str){

    try{
      for (int i = 0; i < str.length() + 1; i++){
        System.out.println(str.charAt(i));
      }
    } 
    catch(StringIndexOutOfBoundsException e){
      System.out.println("String Out of bound exception caught");
    }

  }

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    // taking input from the user
    String str = sc.next();
    try{
      generateException(str);
    } 
    catch(StringIndexOutOfBoundsException e){
      System.out.println("Index out of bound error occur");
    }
    handleIndexOutOfBounds(str);
    sc.close();
  }
}