package collections;
import java.util.*;
public class NthElement {
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        LinkedList<String> list=new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        System.out.println("Enter the nth number");
        int n=ob.nextInt();
        Element.nth(list,n);
    }
}
class Element{
    public static void nth(LinkedList<String>list,int n){
        Collections.sort(list);
        System.out.println(n-1);
    }
}