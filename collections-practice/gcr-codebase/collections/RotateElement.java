package collections;
import java.util.*;
public class RotateElement {
    public static void main(String[] args) {
        Scanner ob=new Scanner (System.in);
        System.out.print("Enter number of elements: ");
        int n=ob.nextInt();
        List<Integer> list=new ArrayList<>();
        System.out.println("Enter elements:");
        for(int i=0;i<n;i++){   
            list.add(ob.nextInt());
        }
        System.out.print("Enter number of rotations: ");
        int r=ob.nextInt();
        ElementRotator.rotateList(list,r);
    }
}
class ElementRotator {
    public static void rotateList(List<Integer> list,int r){
        int n=list.size();
        r=r%n;
        List<Integer> rotated=new ArrayList<>();
        for(int i=0;i<n;i++){
            rotated.add(list.get((i+r)%n));
        }
        System.out.println("Rotated List: "+rotated);
    }
}