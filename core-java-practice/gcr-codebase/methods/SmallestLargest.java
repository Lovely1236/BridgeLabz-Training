import java.util.*;
public class SmallestLargest {
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        System.out.println("Enter the three numbers");
        int num1=ob.nextInt();
        int num2=ob.nextInt();
        int num3=ob.nextInt();
        int[] result = findSmallestAndLargest(num1, num2, num3);

        System.out.println("Largest number: " + result[0]);
        System.out.println("Smallest number: " + result[1]);          ob.close();
    }
    public static int[] findSmallestAndLargest(int num1,int num2,int num3){
         int largest = num1;
        int smallest = num1;

        if (num2 > largest) {
            largest = num2;
        }
        if (num3 > largest) {
            largest = num3;
        }

        if (num2 < smallest) {
            smallest = num2;
        }
        if (num3 < smallest) {
            smallest = num3;
        }
            return new int[] { largest, smallest };
    }
}