package runtime_analysis;

import java.util.*;
public class LinearBinary {
    public static void main(String args[])
    {
        Scanner ob=new Scanner(System.in);
        System.out.println("Enter the size of array:");
        int n=ob.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter the elements of array:");
        for(int i=0;i<n;i++)
        {
            arr[i]=ob.nextInt();
        }
        System.out.println("Enter the element to be searched:");
        int key=ob.nextInt();
        Search.performanceTest(arr,key);
    }
}
class Search{
    public static void performanceTest(int arr[],int key)
    {
        double start1=System.nanoTime();
        linearSearch(arr,key);
        double end1=System.nanoTime();
        double timeTaken1=end1-start1;
        System.out.println("Time taken by Linear Search: "+timeTaken1+" nanoseconds");
        double start2=System.nanoTime();
        binarySearch(arr,key);
        double end2=System.nanoTime();
        double timeTaken2=end2-start2;
        System.out.println("Time taken by Binary Search: "+timeTaken2+" nanoseconds");
    }
    public static void linearSearch(int arr[],int key)
    {
        double start=System.nanoTime();
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==key)
            {
                System.out.println("Element found at index: "+i);
                break;
            }
        }
    }
    public static void binarySearch(int arr[],int key)
    {
        Arrays.sort(arr);
        int left=0;
        int right=arr.length-1;
        while(left<=right)
        {
            int mid=(left+right)/2;
            if(arr[mid]==key)
            {
                System.out.println("Element found at index: "+mid);
                break;
            }
            else if(arr[mid]<key)
            {
                left=mid+1;
            }
            else
            {
                right=mid-1;
            }
        }
    }
}