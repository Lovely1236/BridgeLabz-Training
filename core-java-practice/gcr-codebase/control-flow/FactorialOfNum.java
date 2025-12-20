import java.util.*;
public class FactorialOfNum {
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);

       int num= sc.nextInt();
       int factorial= 1;

       // Calculation of Factorial using while loop
       while(num >= 1) {
           factorial = factorial * num;
           num--;
       }
       
       System.out.println("The factorial of " + num + " is " + factorial);
       sc.close();
   } 
}
