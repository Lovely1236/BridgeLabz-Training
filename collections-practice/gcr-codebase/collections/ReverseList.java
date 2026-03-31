package collections;
import java.util.*;
public class ReverseList {
    public static void main(String[] args) {
        Scanner ob=new Scanner (System.in);
        System.out.print("Enter number of elements: ");
        int n=ob.nextInt();
        List<Integer> list=new ArrayList<>();
        System.out.println("Enter elements:");
        for(int i=0;i<n;i++){   
            list.add(ob.nextInt());
        }
        ArrayListReverser.ReverseList(list);
        LinkedListReverser.ReverseList(list);
    }
}
class ArrayListReverser {
    public static void ReverseList(List<Integer> list){
        ArrayList<Integer> temp=new ArrayList<>();
        for(int i=list.size()-1;i>=0;i--){
            temp.add(list.get(i));
        }
        System.out.println("Reversed List: "+temp);
    }
}
class LinkedListReverser {
    public static void ReverseList(List<Integer> list){
        LinkedList<Integer> temp=new LinkedList<>();
        for(int i=list.size()-1;i>=0;i--){
            temp.add(list.get(i));
        }
        System.out.println("Reversed List: "+temp);
    }
}