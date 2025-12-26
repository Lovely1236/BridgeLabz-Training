import java.util.*;

public class Anagram {

  // method to check anagram condition
  static boolean Anagrams(String first, String second) {
    // remove spaces and convert to lowercase
    first = first.replaceAll("\\s+", "").toLowerCase();
    second = second.replaceAll("\\s+", "").toLowerCase();
    // length check
    if (first.length() != second.length()) {
      return false;
    }
    // ASCII frequency array
    int[] count = new int[256];
    // increase count for first string
    for (int i = 0; i < first.length(); i++) {
      count[first.charAt(i)]++;
    }
    // decrease count for second string
    for (int i = 0; i < second.length(); i++) {
      count[second.charAt(i)]--;
    }
    // check if all frequencies return to zero
    for (int i = 0; i < 256; i++) {
      if (count[i] != 0) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    System.out.print("Enter first string: ");
    String string1 = s.nextLine();
    System.out.print("Enter second string: ");
    String string2 = s.nextLine();
    if (Anagrams(string1, string2)) {
      System.out.println(string1 + " and " + string2 + " are anagrams");
    } else {
      System.out.println(string1 + " and " + string2 + " are not anagrams");
    }
    s.close();
  }
}