import java.util.*;
public class HarshadNumber {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int number = sc.nextInt();
        int originalNum = number;

        int sum = 0;

        while (number != 0) {
            
            int digit = number % 10;
            sum += digit;
            number /= 10;
        }
        if (originalNum % sum == 0) {

            System.out.println(originalNum + " is a Harshad number.");
        } 
        else {

            System.out.println(originalNum + " is not a Harshad number.");
        }
    }
}