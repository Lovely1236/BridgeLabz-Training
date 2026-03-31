import java.util.Scanner;

public class FindShortestAndLongestString {

  // spli without using built in function
  public static String[] splitManually(String str) {

    int word = 1;
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == ' ') {
        word++;
      }
    }

    // now make an array of the words length
    String[] splitString = new String[word];
    String temp = "";
    int index = 0;

    for (int i = 0; i < str.length(); i++) {
    if (str.charAt(i) != ' ') {
        temp += str.charAt(i);
    } else {
        splitString[index] = temp;
        temp = "";
        index++;
    }
}


    splitString[index] = temp; // for last

    return splitString;

  }

  // for find the length without using length()
  public static int findLength(String str) {
    int count = 0;
    for (char c : str.toCharArray()) {
      count++;
    }
    return count;
  }

  // return 2D array of word and length
  public static String[][] wordWithLength(String[] words) {
    String[][] arr = new String[words.length][2];

    for (int i = 0; i < words.length; i++) {
      arr[i][0] = words[i];
      arr[i][1] = String.valueOf(findLength(words[i]));
    }
    return arr;
  }

  // find shortest & longest word indexes
  public static int[] findShortestAndLongest(String[][] arr) {

    int min = Integer.parseInt(arr[0][1]);
    int max = min;
    int minIndex = 0;
    int maxIndex = 0;

    for (int i = 1; i < arr.length; i++) {
      int len = Integer.parseInt(arr[i][1]);

      if (len < min) {
        min = len;
        minIndex = i;
      }
      if (len > max) {
        max = len;
        maxIndex = i;
      }
    }

    return new int[] { minIndex, maxIndex };
  }

  // main method
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    // input
    String text = sc.nextLine();

    String[] words = splitManually(text);
    String[][] wordLen = wordWithLength(words);
    int[] result = findShortestAndLongest(wordLen);

    System.out.println("Shortest word: " + wordLen[result[0]][0]);
    System.out.println("Longest word: " + wordLen[result[1]][0]);
    sc.close();
  }
}