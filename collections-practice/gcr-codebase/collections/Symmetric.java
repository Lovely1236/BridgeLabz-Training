package collections;
import java.util.*;
public class Symmetric {
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        Set<Integer> set1=new HashSet<>();
        Set<Integer> set2=new HashSet<>();
        System.out.print("Enter number of elements in Set1: ");
        int n1=ob.nextInt();
        for(int i=0;i<n1;i++){
            System.out.print("Enter element "+(i+1)+": ");
            set1.add(ob.nextInt());
        }
        System.out.print("Enter number of elements in Set2: ");
        int n2=ob.nextInt();
        for(int i=0;i<n2;i++){
            System.out.print("Enter element "+(i+1)+": ");
            set2.add(ob.nextInt());
        }
        Difference.find(set1, set2);
    }
}
class Difference{
    public static void find(Set<Integer>set1,Set<Integer>set2){
        Set<Integer> diff1=new HashSet<>(set1);
        Set<Integer> diff2=new HashSet<>(set2);
        diff1.removeAll(set2);
        diff2.removeAll(set1);
        diff1.addAll(diff2);
        System.out.println("Symmetric Difference: "+diff1);
    }
}