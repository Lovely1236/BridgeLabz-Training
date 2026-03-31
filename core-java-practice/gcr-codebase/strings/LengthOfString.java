import java.util.Scanner;

public class LengthOfString {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // taking input from the user
    String str = sc.next();

    // take count name variable and after each char we increase the count by 1 and
    // at last print as output that is the length
    int count = 0;
    for (int i = 0; i < str.length(); i++) {
      count++;
    }
    System.out.println(count);
    sc.close();
  }
}