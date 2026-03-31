package runtime_analysis;

import java.util.*;
public class SearchDS {
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        System.out.println("Enter dataset size:");
        int n=ob.nextInt();
        System.out.println("Enter target value:");
        int target=ob.nextInt();
        performanceTest(n,target);
    }
    public static void performanceTest(int n,int target){
        int arr[]=new int[n];
        HashSet<Integer> hashSet=new HashSet<>();
        TreeSet<Integer> treeSet=new TreeSet<>();
        // Generate dataset
        for(int i=0;i<n;i++){
            arr[i]=i;
            hashSet.add(i);
            treeSet.add(i);
        }
        // Array Search Timing
        long start1=System.nanoTime();
        int arrIndex=linearSearch(arr,target);
        long end1=System.nanoTime();
        // HashSet Search Timing
        long start2=System.nanoTime();
        boolean hashFound=hashSet.contains(target);
        long end2=System.nanoTime();
        // TreeSet Search Timing
        long start3=System.nanoTime();
        boolean treeFound=treeSet.contains(target);
        long end3=System.nanoTime();
        if(arrIndex!=-1){
            System.out.println("Array: Element found at index "+arrIndex);
        } else {
            System.out.println("Array: Element not found");
        }
        System.out.println("HashSet: Element found = "+hashFound);
        System.out.println("TreeSet: Element found = "+treeFound);
        System.out.println("Execution Time:");
        System.out.println("Array Search Time (ns): "+(end1-start1));
        System.out.println("HashSet Search Time (ns): "+(end2-start2));
        System.out.println("TreeSet Search Time (ns): "+(end3-start3));
    }
    public static int linearSearch(int arr[],int target){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==target){
                return i;
            }
        }
        return -1;
    }
}