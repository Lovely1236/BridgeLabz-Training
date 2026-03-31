import java.util.Scanner;

public class ReplaceWord{
  // custom method to replace a word in a sentence
  static String replaceWord(String sentence, String oldWord, String newWord){
    String res = "";
    int i = 0;
    while(i < sentence.length()){
      // check if oldWord matches starting at index i
      if(i + oldWord.length() <= sentence.length() && sentence.substring(i, i + oldWord.length()).equals(oldWord)){
        res += newWord;
        // Skip old word
        i += oldWord.length();
      } else{
        res += sentence.charAt(i);
        i++;
      }
    }
    return res;
  }

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    // input the sentence
    System.out.print("Enter a sentence:- ");
    String sentence = sc.nextLine();
    // word to replace
    System.out.print("Enter word to replace:- ");
    String oldWord = sc.nextLine();
    // word to replace with
    System.out.print("Enter new word:- ");
    String newWord = sc.nextLine();
    String output = replaceWord(sentence, oldWord, newWord);
    // display updated sentence
    System.out.println("Updated sentence:- " + output);
    sc.close();
  }
}