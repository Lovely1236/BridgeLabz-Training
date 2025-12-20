import java.util.*;
public class CalculatorSwitchCase {
     public staticvoid main(String[] args){
           Scanner sc = new Scanner(System.in);
         
            System.out.println("Enter first number:");
            double first = sc.nextDouble();
         
            System.out.println("Enter second number:");
            double second = sc.nextDouble();

            System.out.println("Choose an operation: +, -, *, /");
            String op = sc.next().charAt(0);
         
            double result;
         
            switch(op) {
             case "+":
                 result = first + second;
                 System.out.println("Result: " + result);
                 break;
             case "-":
                 result = first - second;
                 System.out.println("Result: " + result);
                 break;
             case "*":
                 result = first * second;
                 System.out.println("Result: " + result);
                 break;
             case "/":
                 if (second != 0) {
                     result = first / second;
                     System.out.println("Result: " + result);
                 } 
                 else {
                     System.out.println("Error: Division by zero");
                 }
                 break;
             default:
                 System.out.println("Invalid operator");
                 break;
         }
         
         sc.close();
     }
}
