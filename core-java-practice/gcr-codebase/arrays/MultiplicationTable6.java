import java.util.Scanner;

public class MultiplicationTable6 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");

        int number = sc.nextInt();

        
        // Array to store multiplication results (for 6 to 9)
        int[] multiplicationRes = new int[4];

       
       
        // Calculate multiplication table from 6 to 9
        for(int i = 6; i <= 9; i++){
        
            multiplicationRes[i - 6]= number * i;
        }
 // Display result
        
 System.out.println("\nMultiplication Table:");

        for(int i = 6; i <= 9; i++){
            
            System.out.println(number + " * " + i + " = " + multiplicationRes[i - 6]);
        }


        sc.close();
    }
}
