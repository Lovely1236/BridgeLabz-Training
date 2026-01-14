import java.util.*;
public class SlidingWindow{
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        System.out.println("Enter size of array:");
        int n=ob.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter array elements:");
        for(int i=0;i<n;i++)
            arr[i]=ob.nextInt();
        System.out.println("Enter window size:");
        int k=ob.nextInt();
        int result[]=maxSlidingWindow(arr,k);
        System.out.println("Sliding Window Maximum:");
        for(int i=0;i<result.length;i++)
            System.out.print(result[i]+" ");
    }
    public static int[] maxSlidingWindow(int arr[],int k){
        int n=arr.length;
        int result[]=new int[n-k+1];
        Deque<Integer> deque=new ArrayDeque<>();
        int index=0;
        for(int i=0;i<n;i++){
            if(!deque.isEmpty()&&deque.peekFirst()<=i-k)
                deque.pollFirst();
            while(!deque.isEmpty()&&arr[deque.peekLast()]<=arr[i])
                deque.pollLast();
            deque.offerLast(i);
            if(i>=k-1){
                result[index]=arr[deque.peekFirst()];
                index++;
            }
        }
        return result;
    }
}