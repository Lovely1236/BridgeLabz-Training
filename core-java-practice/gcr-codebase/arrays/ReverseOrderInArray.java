import java.util.*;

public class ReverseOrderInArray {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // taking input
    int n = sc.nextInt();

    String x = Integer.toString(n);
    int size = x.length();

    int[] arr = new int[size]; // to store the values

    // reverse the string
    StringBuilder str = new StringBuilder(x);
    str.reverse();

    // store the values in form after converting it into int
    for (int i = 0; i < size; i++) {
      arr[i] = str.charAt(i) - '0';
    }

    // now print the string
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i] + " ");
    }
    sc.close();
  }
}