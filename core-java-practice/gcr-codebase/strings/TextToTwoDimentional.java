import java.util.*;

public class TextToTwoDimentional {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // user input
    System.out.print("Enter text ");
    String text = sc.nextLine();
    // split text into words using .split()
    String[] words = text.split(" ");
    // create 2D array
    String[][] data = new String[words.length][2];
    for (int i = 0; i < words.length; i++) {
      data[i][0] = words[i];
      data[i][1] = String.valueOf(words[i].length());
    }
    // display result
    System.out.println("\nWord\tLength");
    for (int i = 0; i < data.length; i++) {
      // string to int
      int length = Integer.parseInt(data[i][1]);
      System.out.println(data[i][0] + "\t" + length);
      sc.close();
    }
  }
}