import java.util.Scanner;
public class GCDandLCM{
    public static int findGCD(int a, int b){    // Method to calculate GCD using Euclidean Algorithm
        if (b == 0){
            return a;
        } return findGCD(b, a % b);
    }
    public static int findLCM(int a, int b){      // Method to calculate LCM using GCD
        return (a * b) / findGCD(a, b);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();
        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();
        int gcd = findGCD(num1, num2);
        int lcm = findLCM(num1, num2);
        System.out.println("GCD is " + gcd);
        System.out.println("LCM is " + lcm);
        sc.close();
    }
}
