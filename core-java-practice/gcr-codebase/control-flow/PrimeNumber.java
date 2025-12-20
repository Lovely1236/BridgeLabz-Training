import java.util.*;
public class PrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        for (int i = 2; i < numner; i++) {
            if (number % i == 0) {
                System.out.println("Not a Prime");
                return;
            }

        }
        System.out.println("Is a Prime");
    }

}