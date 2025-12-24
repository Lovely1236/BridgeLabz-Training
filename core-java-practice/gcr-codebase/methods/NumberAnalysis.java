import java.util.*;
public class NumberAnalysis {
    public static boolean isPositive(int number) {
        return number >= 0;
    }
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
    public static int compare(int num1, int num2) {
        if (num1 > num2) {
            return 1;
        } else if (num1 == num2) {
            return 0;
        } else {
            return -1;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];
        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = sc.nextInt();
        }
        System.out.println("nNumber Analysis:");
        for (int i = 0; i < numbers.length; i++) {
            if (isPositive(numbers[i])) {
                if (isEven(numbers[i])) {
                    System.out.println(numbers[i] + " is Positive and Even");
                } else {
                    System.out.println(numbers[i] + " is Positive and Odd");
                }
            } else {
                System.out.println(numbers[i] + " is Negative");
            }
        }
        int result = compare(numbers[0], numbers[numbers.length - 1]);
        System.out.println("Comparison of First and Last Element:");
        if (result == 1) {
            System.out.println("First element is Greater than Last element");
        } else if (result == 0) {
            System.out.println("First element is Equal to Last element");
        } else {
            System.out.println("First element is Less than Last element");
        }
        sc.close();
    }
}