import java.util.Scanner;

public class LargestAndSecondLargest{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;


        // Store digits in array
        while(number!=0){

            // Stop if array limit is reached
            if(index==maxDigit){
                break;
            }

            
            
              digits[index]= number%10; // get last digit
            number = number/10;        // remove last digit
            index++;
        }

        // Variables for largest and second largest
        
        int largest = 0;
        int secondLargest = 0;

        // Find largest and second largest digit
        for(int i = 0;i<index;i++){
            
            if(digits[i]>largest){
                
                secondLargest= largest;
                largest= digits[i];
                
            } 
            else if(digits[i]>secondLargest && digits[i]!=largest){
                
                secondLargest=digits[i];
                
            }
        }

        // Display result
        
        System.out.println("\nLargest digit: " + largest);
        
        System.out.println("Second largest digit: " + secondLargest);

        sc.close();
    }
}
