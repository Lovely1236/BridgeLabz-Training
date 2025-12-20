import java.util.*;

public class Frequency {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // taking input from the user
    int n = sc.nextInt();
    int[] arr = new int[n];

    // now store some values in the array
    for (int i = 0; i <= arr.length; i++) {
      arr[i] = sc.nextInt();
    }

    // frequency using HashMap
    HashMap<Integer, Integer> hs = new HashMap<>();

    for (int i = 0; i < arr.length; i++) {
      hs.put(arr[i], hs.getOrDefault(arr[i], 0) + 1);
    }

    // print frequency
    System.out.println("Frequency of elements:");
    for (int key : hs.keySet()) {
      System.out.println(key + " -> " + hs.get(key));
    }
  }
}