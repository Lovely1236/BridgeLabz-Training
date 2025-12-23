import java.util.Scanner;

public class CountVowelsConsonents {

  public static void countVowelsConsonants(String str) {
    int countVOwels = 0, countConsonents = 0, countNoOne = 0;
    String s = str.toLowerCase();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);

      if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
        countVOwels++;
      } else if (ch >= 'a' && ch <= 'z') {
        countConsonents++;
      } else {
        countNoOne++;
      }
    }

    System.out.println("The number of vowels are -: " + countVOwels);
    System.out.println("The number of Consonets are -: " + countConsonents);
    System.out.println("The number of NoOne are -: " + countNoOne);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // taking input from the user
    String str = sc.next();

    // now call the function that print the output
    countVowelsConsonets(str);

  }

}