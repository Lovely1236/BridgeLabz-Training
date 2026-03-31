import java.util.*;

public class GreatestFactorOfNum {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int counter = 1;
        int greatestFactor = 1;
        for (int i = number-1; i >= 1; i--) {

            if (number % i == 0) {
                greatestFactor = i;
                break;
            }
        }
        System.out.println("The greatest factor of " + number + " is " + greatestFactor);
        sc.close();
    }
}