package collections;
import java.util.*;
public class SortSet {
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        Set<Integer> set=new HashSet<>();
        System.out.print("Enter number of elements in Set1: ");
        int n1=ob.nextInt();
        for(int i=0;i<n1;i++){
            System.out.print("Enter element "+(i+1)+": ");
            set.add(ob.nextInt());
        }
        Sort.ans(set);
    }
}
class Sort{
    public static void ans(Set<Integer>set){
        List<Integer> list=new ArrayList<>(set);
        Collections.sort(list);
        System.out.println("Sorted List: "+list);
    }
}