import java.util.Scanner;

public class QuotientRemainder {
    public static void main(String[] args) {
           Scanner sc = new Scanner(System.in);
           System.out.println("Enter the number:"); // Ask the user for input
           int number = sc.nextInt();
           System.out.println("Enter the divisor:");
           int divisor = sc.nextInt();
           if (divisor == 0) {// Check for division by zero
            System.out.println("Division by zero is not allowed.");
           }
           else {
            int[] result = calculateQuotientAndRemainder(number, divisor);
            System.out.println("Quotient is: " + result[0]);
            System.out.println("Remainder is: " + result[1]);
        }
         sc.close();
    }
        // This method calculates and returns quotient and remainder
    public static int[] calculateQuotientAndRemainder(int number, int divisor) {
        int quotient = number / divisor;
        int remainder = number % divisor;
        return new int[] { quotient, remainder };
    }
}
