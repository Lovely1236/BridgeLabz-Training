import java.util.*;
public class CheckNumber {
     
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int number =  sc.nextInt();
           
        // Checking  if the number is positive, negative, or zero
        
        if(number > 0) {

            System.out.println("Number is positive");

        }
         else if (number < 0) {

            System.out.println("Number is negative");

        } 
        
        else {

            System.out.println("zero");
        }

        sc.close();
    }
}
