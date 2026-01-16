package sorting_algo;
public class CountingSort {
    public static void countingSort(int[] arr) {
        int n = arr.length;
// Step 1: find max element
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        // Step 2: create count array
        int[] count = new int[max + 1];

        // Step 3: store frequency
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }

        // Step 4: rebuild sorted array
        int index = 0;
        for (int i = 0; i <= max; i++) {
            while (count[i] > 0) {
                arr[index++] = i;
                count[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 8, 3, 3, 1};

        countingSort(arr);

        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}
