import java.util.Scanner;
public class FibonacciSequence{
    public static void printFibonacci(int terms){     // Method to generate and print Fibonacci sequence
        int first = 0, second = 1;
        if(terms <= 0){
            System.out.println("Please enter a positive number");
            return;
        }
        System.out.print("Fibonacci Sequence: ");
        for (int i = 1; i <= terms; i++) {
            System.out.print(first + " ");
            int nextNum = first + second;
            first = second;
            second = nextNum;}
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of terms: ");
        int terms = sc.nextInt();
        printFibonacci(terms);
        sc.close();
    }
}
