package collections;
import java.util.*;
public class RemoveDuplicate {
    public static void main(String[] args) {
        Scanner ob =new Scanner(System.in);
        System.out.println("Enter the number of elements");
        int n=ob.nextInt();
        ArrayList<Integer> list=new ArrayList<>();
        System.out.println("Enter the elements");
        for (int i = 0; i < n; i++) {
            list.add(ob.nextInt());
        }
        Remove.duplicate(list);
    }
}
class Remove{
    public static void duplicate(List<Integer>list){
        Set<Integer> seen=new HashSet<>();
        List<Integer> result=new ArrayList<>();
        for(int num:list){
            if(!seen.contains(num)){
                seen.add(num);
                result.add(num);
            }
        }
        System.out.println(result);
    }
}