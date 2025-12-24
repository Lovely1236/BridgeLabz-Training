import java.util.*;
public class CompareNaturalNumber {
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        System.out.println("Enter the number");
        int num=ob.nextInt();
        if(num>0){
             System.out.println("Sum of Natural Number using Recursion: "+recursive(num));
            System.out.println("Sum of Natural Number using formula: "+formula(num));
        }
        else{
            System.out.println("Enter a natural number");
        }
        ob.close();
    }
    public static int recursive(int num){
        if(num==1)
            return num;
        return num+recursive(num-1);
    }
    public static int formula(int num){
        return  num*(num+1)/2;
    }
}