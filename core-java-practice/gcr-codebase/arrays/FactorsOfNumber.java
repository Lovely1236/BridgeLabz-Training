import java.util.Scanner;


public class FactorsOfNumber{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number--> ");
        
        int number = sc.nextInt();

        // Initial array size
        int maxFactor = 10;
        int[] factors = new int[maxFactor];
        int index = 0;

        // Find factors
        for(int i = 1;i <= number;i++){
            if(number % i == 0) {

                // Resize array if needed
                
                   if(index == maxFactor){
                       
                      maxFactor = maxFactor * 2;
                      int[] temp = new int[maxFactor];
                      

                    // Copy old elements to new array
                    for(int j = 0; j < factors.length; j++){
                        
                        temp[j] = factors[j];
                    }
                    

                    factors = temp;
                }

                // Store factor
                
                factors[index] = i;
                index++;
            }
        }
        

        // Display factors
        System.out.println("\nFactors are --> ");
        
        for(int i = 0;i < index;i++){
            
            System.out.print(factors[i] + " ");
        }


        sc.close();
    }
}
