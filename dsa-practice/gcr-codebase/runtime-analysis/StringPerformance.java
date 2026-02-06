package runtime_analysis;
import java.util.*;
public class StringPerformance {
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        System.out.println("Enter number of concatenations:");
        int n=ob.nextInt();
        performanceTest(n);
    }
    public static void performanceTest(int n){
        // String Test
        long start1=System.nanoTime();
        String str="";
        for(int i=0;i<n;i++){
            str=str+"hello";
        }
        long end1=System.nanoTime();
        // StringBuilder Test
        long start2=System.nanoTime();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append("hello");
        }
        long end2=System.nanoTime();
        // StringBuffer Test
        long start3=System.nanoTime();
        StringBuffer sf=new StringBuffer();
        for(int i=0;i<n;i++){
            sf.append("hello");
        }
        long end3=System.nanoTime();
        System.out.println("String Time (ns): "+(end1-start1));
        System.out.println("StringBuilder Time (ns): "+(end2-start2));
        System.out.println("StringBuffer Time (ns): "+(end3-start3));
    }
}