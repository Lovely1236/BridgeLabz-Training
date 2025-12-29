import java.util.Scanner;
public class BasicCalculator{
    public static double add(double a, double b){     // Addition
        return a + b;
    }
    public static double sub(double a, double b){     // Subtraction
        return a - b;
    }
    public static double product(double a, double b){     // Multiplication
        return a * b;
    }
    public static double divide(double a, double b){     // Division
        if(b==0){
            System.out.println("Division by zero is not allowed");
            return 0;
        } return a / b;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Basic Calculator");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.print("Choose an operation: ");
        int ch = sc.nextInt();
        System.out.print("Enter first number: ");
        double num1 = sc.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = sc.nextDouble();
        switch (ch){
            case 1:
                System.out.println("Result: " + add(num1, num2));
                break;
            case 2:
                System.out.println("Result: " + sub(num1, num2));
                break;
            case 3:
                System.out.println("Result: " + product(num1, num2));
                break;
            case 4:
                System.out.println("Result: " + divide(num1, num2));
                break;
            default:
                System.out.println("Invalid choice");
        }
        sc.close();
    }
}
