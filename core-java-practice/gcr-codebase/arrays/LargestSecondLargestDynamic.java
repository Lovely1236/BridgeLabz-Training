import java.util.Scanner;

public class LargestSecondLargestDynamic{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();


        // Initial array size

        int maxDigit = 10;
        int[] digits = new int[maxDigit];


        int index = 0;

        // Store digits dynamically
        while(number!=0){

            // If array is full, increase size by 10
            if(index==maxDigit){
                maxDigit = maxDigit + 10;

                int[] temp = new int[maxDigit];

                // Copy old digits into new array
                for(int i = 0;i<digits.length;i++){

                    temp[i] = digits[i];
                }

                digits = temp;
            }


            // Extract and store digit
            digits[index] = number % 10;

            number = number / 10;
            index++;
        }

        // Variables for largest and second largest
        int largest = 0;

        int secondLargest = 0;

        // Find largest and second largest digit

        for(int i = 0;i<index;i++){

            if(digits[i]>largest){

                secondLargest = largest;

                largest = digits[i];

            } 
            else if(digits[i]>secondLargest && digits[i]!=largest){

                secondLargest = digits[i];
            }
        }

        // Display result


        System.out.println("\nLargest digit: " + largest);
        
        System.out.println("Second largest digit: " + secondLargest);

        sc.close();
    }
}
