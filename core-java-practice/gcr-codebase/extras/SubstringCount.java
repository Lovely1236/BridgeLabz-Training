import java.util.*;

public class SubstringCount {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // Take input
    System.out.print("Enter the main string: ");
    String mainString = sc.nextLine();

    System.out.print("Enter the substring: ");
    String subString = sc.nextLine();

    int count = 0;

    // Loop through main string
    for (int i = 0; i <= mainString.length() - subString.length(); i++) {

      // Compare substring
      if (mainString.substring(i, i + subString.length()).equals(subString)) {
        count++;
      }
    }

    // Output result
    System.out.println("Substring occurs " + count + " times");

    sc.close();
  }
}