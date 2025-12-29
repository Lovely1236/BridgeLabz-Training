import java.util.Scanner;
public class PrimeNumberChecker{
    public static boolean isPrime(int number){    // Method to check whether a number is prime
        if(number<=1){
            return false;
        }
        for(int i = 2;i<=Math.sqrt(number);i++){
            if (number%i == 0) {
                return false;
            } }
        return true;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        if(isPrime(num)) {
            System.out.println(num + " is a PRIME number");
        } 
        else {
            System.out.println(num + " is NOT a prime number");
        }
        sc.close();
    }
}
