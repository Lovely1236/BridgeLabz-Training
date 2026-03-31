import java.util.*;
public class DivisibleByFive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();


        // Check if the number is divisible by 5
        if (number % 5 == 0) {

            System.out.println(" Is the number " + number + " divisible by 5? Yes");

        } else {
// If not divisible by 5
            System.out.println(" Is the number " + number + " divisible by 5? No");
        }
        sc.close();
    }
    
}
