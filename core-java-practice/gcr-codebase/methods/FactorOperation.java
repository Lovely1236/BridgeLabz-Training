import java.util.*;
public class FactorOperation {
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        System.out.println("Enter the number");
        int number=ob.nextInt();
        int count=count(number);
        int factor[]=factor(count,number);
        System.out.print("Factors are: ");
        for(int i=0;i<factor.length;i++)
            System.out.print(factor[i]+" ");
        System.out.println();
        System.out.println("Sum of square of factors is: "+square(factor));
        System.out.println("Product of factors is: "+product(factor));
        ob.close();
    }
    public static int count(int num){
        int count=0;
        for(int i=1;i<=num;i++){
            if(num%i==0)count++;
        }
        return count;
    }
    public static int[] factor(int count,int number){
        int arr[]=new int[count];
        int j=0;
        for(int i=1;i<=number;i++){
            if(number%i==0){
                arr[j]=i;
                j++;
            }
        }
        return arr;
    }
    public static int product(int factor[]){
        int pro=1;
        for(int i=0;i<factor.length;i++){
            pro*=factor[i];
        }
        return pro;
    }
    public static int square(int factor[]){
        int sum=0;
        for(int j=0;j<factor.length;j++){
            sum+=Math.pow(factor[j],2);
        }
        return sum;
    }
}