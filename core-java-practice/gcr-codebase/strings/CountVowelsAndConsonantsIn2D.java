import java.util.Scanner;

public class CountVowelsAndConsonantsIn2D{
  // method to check character type
  static String checkCharType(char ch) {
    // convert uppercase to lowercase
    if (ch >= 'A' && ch <= 'Z') {
      ch = (char) (ch + 32);
    }
    // check if character is an alphabet
    if (ch >= 'a' && ch <= 'z') {
      // check for vowels
      if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
        return "Vowel";
      } else {
        return "Consonant";
      }
    }
    // if not an alphabet
    return "Not a Letter";
  }

  // method to create 2D array of character and its type
  static String[][] findCharType(String text) {
    String[][] res = new String[text.length()][2];
    for (int i = 0; i < text.length(); i++) {
      res[i][0] = String.valueOf(text.charAt(i)); // store character
      res[i][1] = checkCharType(text.charAt(i)); // store type
    }
    return res;
  }

  // method to display 2D array in tabular format
  static void display(String[][] data) {
    System.out.println("\nCharacter\tType");
    for (String[] rows : data) {
      System.out.println(rows[0] + "\t\t" + rows[1]);
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // take input from user
    System.out.print("Enter a string: ");
    String input = sc.nextLine();
    // call user-defined methods
    String[][] table = findCharType(input);
    // display result
    display(table);
    sc.close();
  }
}