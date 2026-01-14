import java.util.*;
public class TwoSum {
    public static void main(String[] args){
        Scanner ob=new Scanner(System.in);
        System.out.println("Enter number of elements in the array:");
        int n=ob.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter the elements of the array:");
        for(int i=0;i<n;i++){
            arr[i]=ob.nextInt();
        }
        System.out.println("Enter target sum:");
        int target=ob.nextInt();
        findTwoSum(arr,target);
    }
    public static void findTwoSum(int arr[],int target){
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int required=target-arr[i];
            if(map.containsKey(required)){
                System.out.println("Two Sum found at indices "+map.get(required)+" and "+i);
                return;
            }
            map.put(arr[i],i);
        }
        System.out.println("No Two Sum pair found");
    }
}