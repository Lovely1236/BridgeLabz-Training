package sorting_algo;
import java.util.*;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter array elements");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < n - 1; i++) {
            boolean swap = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swap = true; 
                }
            }

            if (!swap) break;
        }

        // Print sorted array
        for (int num : arr) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}
