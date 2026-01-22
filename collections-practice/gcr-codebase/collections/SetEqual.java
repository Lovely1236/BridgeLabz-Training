package collections;
import java.util.*;
public class SetEqual {
    public static void main(String args[]){
        Scanner ob=new Scanner (System.in);
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
        Equal.check(set1, set2);
    }
}
class Equal{
    public static void check(Set<Integer>set1,Set<Integer>set2){
        if(set1.equals(set2))
            System.out.println("true");
        else
            System.out.println("false");
    }
}