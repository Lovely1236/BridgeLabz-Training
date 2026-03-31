import java.util.*;
public class Chocolates {
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        System.out.println("Enter the number of chocolates");
        int choco=ob.nextInt();
        System.out.println("Enter the number of childrens");
        int child=ob.nextInt();
        if (child== 0) {
            System.out.println("Chocolates cannot be distributed among zero children.");
        } else {
            int[] result = findRemainderAndQuotient(choco, child);

            System.out.println("Each child gets: " + result[0] + " chocolates");
            System.out.println("Remaining chocolates: " + result[1]);
        }
        ob.close();
    }
    public static int[] findRemainderAndQuotient(int choco,int child){
        int div=choco/child;
        int rem=choco%child;
        int arr[]={div,rem};
        return arr;
    }
}