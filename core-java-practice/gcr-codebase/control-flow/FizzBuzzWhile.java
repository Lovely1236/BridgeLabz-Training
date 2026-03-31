import java.util.*;
public class FizzBuzzWhile {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = 1;

        while (i <= n) {
            if (i % 3 == 0 && i % 5 == 0) {
                 //if divisible by both 3 and 5 then print FizzBuzz
                System.out.println("FizzBuzz");
            } 
            else if (i % 3 == 0) {
                // if divisible by 3 then print Fizz
                System.out.println("Fizz");
            } 
            
            else if (i % 5 == 0) {
                // if divisible by 5 then print Buzz
                System.out.println("Buzz");
            } 
            else {
                // if not divisible by either 3 or 5 then print the number
                System.out.println(i);
            }
            i++;
        }
        sc.close();
    }
}