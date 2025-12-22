import java.util.Scanner;

public class TextToUpperCase {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // taking input from the user
    String str = sc.nextLine();

    // compare both results
    System.out.println(compareUserDefine(str).equals(userDefine(str)));
    sc.close();
  }

  public static String compareUserDefine(String str) {
    String result = "";

    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);

      // convert lowercase to uppercase manually
      if (ch >= 'a' && ch <= 'z') {
        ch = (char) (ch - 32);
      }
      result = result + ch;
    }
    return result;
  }

  public static String userDefine(String str) {
    return str.toUpperCase();
  }
}