import java.util.*;
public class ZeroSum {
    public static void main(String[] args){
        Scanner ob=new Scanner(System.in);
        System.out.println("Enter number of elements in the array:");
        int n=ob.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter the elements of the array:");
        for(int i=0;i<n;i++){
            arr[i]=ob.nextInt();
        }
        ZeroSumSubarray(arr);
    }
    public static void ZeroSumSubarray(int arr[]){
        HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
        int currentSum=0;
        boolean found=false;
        for(int i=0;i<arr.length;i++){
            currentSum=currentSum+arr[i];
            if(currentSum==0){
                System.out.println("Subarray found from index 0 to "+i);
                found=true;
            }
            if(map.containsKey(currentSum)){
                ArrayList<Integer> list=map.get(currentSum);
                for(int startIndex:list){
                    System.out.println("Subarray found from index "+(startIndex+1)+" to "+i);
                    found=true;
                }
            }
            if(!map.containsKey(currentSum))
                map.put(currentSum,new ArrayList<>());
            map.get(currentSum).add(i);
        }
        if(!found)
            System.out.println("No zero sum subarray found");
    }
}