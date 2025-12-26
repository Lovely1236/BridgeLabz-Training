import java.util.*;

public class RemoveSpecificCharacter {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // taking input from the user
    System.out.print("Enter the sentence -:");
    String str = sc.nextLine();
    System.out.print("Enter the letter you want to remove -:");
    String letter = sc.next();

    // run loop and use replace method to replace it
    for (int i = 0; i < str.length(); i++) {
      if (String.valueOf(str.charAt(i)).equals(letter)) {
        str = str.replace(letter, "");
        break;
      }
    }
    System.out.println("Modified String -:" + str);
  }
}