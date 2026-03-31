import java.util.*;
public class ConsecutiveSequence {
    public static void main(String[] args){
        Scanner ob=new Scanner(System.in);
        System.out.println("Enter number of elements in the array:");
        int n=ob.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter the elements of the array:");
        for(int i=0;i<n;i++){
            arr[i]=ob.nextInt();
        }
        longestConsecutiveSequence(arr);
    }
    public static void longestConsecutiveSequence(int arr[]){
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],i);
        }
        int maxLen=0;
        for(int num:map.keySet()){
            if(!map.containsKey(num-1)){
                int currentNum=num;
                int currentLen=1;
                while(map.containsKey(currentNum+1)){
                    currentNum++;
                    currentLen++;
                }
                maxLen=Math.max(maxLen,currentLen);
            }
        }
        System.out.println("Length of longest consecutive sequence: "+maxLen);
    }
}
