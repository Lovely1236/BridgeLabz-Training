import java.util.*;

public class NumberFormatExceptionDemo{
  // this is for generate exception
  public static void generateException(String str){

    System.err.println(Integer.parseInt(str));
  }

  // this is for caught the illegal argument
  public static void handleNumberFormatException(String str){

    try{
      System.err.println(Integer.parseInt(str));

    } 
    catch(NumberFormatException e){
      System.out.println(" NumberFormatException caught");
    }

  }

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    // taking input from the user
    String str = sc.next();
    try{
      generateException(str);
    } 
    catch(NumberFormatException e){
      System.out.println("NumberFormatException occur");
    }
    handleNumberFormatException(str);
    sc.close();
  }
}