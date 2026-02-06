package runtime_analysis;

import java.util.*;
public class Fibonacci {
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        System.out.println("Enter Fibonacci number N:");
        int n=ob.nextInt();
        performanceTest(n);
    }
    public static void performanceTest(int n){
        // Recursive Test
        long start1=System.nanoTime();
        int recResult=fibonacciRecursive(n);
        long end1=System.nanoTime();
        // Iterative Test
        long start2=System.nanoTime();
        int itrResult=fibonacciIterative(n);
        long end2=System.nanoTime();
        System.out.println("Recursive Fibonacci Result: "+recResult);
        System.out.println("Iterative Fibonacci Result: "+itrResult);
        System.out.println("Execution Time:");
        System.out.println("Recursive Time (ms): "+((end1-start1)/1000000));
        System.out.println("Iterative Time (ms): "+((end2-start2)/1000000));
    }
    public static int fibonacciRecursive(int n){
        if(n<=1){
            return n;
        }
        return fibonacciRecursive(n-1)+fibonacciRecursive(n-2);
    }
    public static int fibonacciIterative(int n){
        if(n<=1){
            return n;
        }
        int a=0;
        int b=1;
        int sum=0;
        for(int i=2;i<=n;i++){
            sum=a+b;
            a=b;
            b=sum;
        }
        return b;
    }
}