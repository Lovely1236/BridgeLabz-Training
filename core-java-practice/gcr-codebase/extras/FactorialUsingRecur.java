import java.util.Scanner;
public class FactorialUsingRecur{
    public static int forInput(){      // Method to take input from user
        Scanner ob = new Scanner(System.in);
        System.out.print("Enter a number: ");
        return ob.nextInt();
    }
    public static long fact(int n){    // Recursive method to calculate factorial
        if(n==0 || n==1){
            return 1;
        }
        return n * fact(n - 1);
    }
    public static void result(int n, long result){     // Method to display result
        System.out.println("Factorial of " + n + " is: " + result);
    }
    public static void main(String[] args){
        int num = forInput();
        if(num<0){
            System.out.println("Factorial is not defined for negative numbers");
        } 
        else{
            long res = fact(num);
            result(num, res);
        }
    }
}
