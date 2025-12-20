import java.util.Scanner;

public class OddEvenArray {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter a natural number: ");
        int number = sc.nextInt();

        // Check for natural number
        if(number <= 0){
            
            System.out.println("Error: Please enter a natural number");
            sc.close();
            
            return;
        }

        
        // Create arrays for odd and even numbers
          int halfSize = number / 2 + 1;
          
        int[] even = new int[size];
        int[] odd = new int[size];

        // Index variables
        
        int evenIndx = 0;
        int oddIndx = 0;
        

          for(int i = 1; i <= number; i++){
              
            if (i % 2 == 0){
                even[evenIndex] = i;
                
                evenIndex++;
            } 
            else {
                
                odd[oddIndex] = i;
                
                oddIndex++;
            }
        }

        // Print odd Numbers
        
        System.out.println("\nOdd Numbers:");
        
        for(int i = 0; i < oddIndex; i++){
            
            System.out.print(odd[i] + " ");
        }

        // Print even numbers
        
        System.out.println("\n\nEven Numbers:");
        
        for(int i = 0; i < evenIndex; i++){
            
            System.out.print(even[i] + " ");
            
        }

        sc.close();
    }
}
