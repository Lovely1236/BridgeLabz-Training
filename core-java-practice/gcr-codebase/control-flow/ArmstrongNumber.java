import java.util.*;
public class ArmstrongNumber {
     
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        
        int number = sc.nextInt();
        int originalNum = number;

        int sum = 0;
        int digits = String.valueOf(number).length();

        while (number != 0) {
            int digit = number % 10;
            sum += Math.pow(digit, digits);
            number /= 10;
        }


        if (sum == originalNum) {
            System.out.println(originalNum + " is an Armstrong number.");
        } 
        else {
            System.out.println(originalNum + " is not an Armstrong number.");
        }

        sc.close();
    }
}
