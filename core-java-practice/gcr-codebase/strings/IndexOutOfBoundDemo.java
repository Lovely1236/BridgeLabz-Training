import java.util.*;

public class IndexOutOfBoundDemo {
  // this is for generate exception
  public static void generateException(String str) {

    for (int i = str.length() + 2; i < str.length(); i++) {
      System.out.println(str.charAt(i));
    }
  }

  // this is for caught the illegal argument
  public static void handleIndexOutOfBoundsException(String str) {

    try {
      for (int i = str.length() + 2; i < str.length(); i++) {
        System.out.println(str.charAt(i));
      }

    } catch (IndexOutOfBoundsException e) {
      System.out.println(" IndexOutOfBoundsException caught");
    }

  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // taking input from the user
    String str = sc.next();
    try {
      generateException(str);
    } catch (IndexOutOfBoundsException e) {
      System.out.println("IndexOutOfBoundsException occur");
    }
    handleIndexOutOfBoundsException(str);
    sc.close();
  }
}