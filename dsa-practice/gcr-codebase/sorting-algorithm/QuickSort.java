package sorting_algo;
public class QuickSort{
	public static void quickSort(int[] arr, int low, int high) {
        if(low < high){
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }
    static int partition(int[] arr, int low, int high){
        int pivot = arr[high]; // last element as pivot
        int i = low - 1;
       for(int j = low; j < high; j++){
            if(arr[j] < pivot){
                i++;
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
           }
        }

        // place pivot at correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2};
        quickSort(arr, 0, arr.length - 1);
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}
