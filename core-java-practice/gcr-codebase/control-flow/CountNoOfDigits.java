import java.util.*;
public class CountNoOfDigits {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int number = sc.nextInt();
        
        int count = 0;
        int temp = number;
        
        if(number == 0) {
            count = 1; // Special case for 0
        } 
        else {
            
            // Counting digits for non-zero numbers
            while(temp != 0) {
                temp /= 10;
                count++;
            }
        }
        

        System.out.println("Number of digits in " + number + " is " + count);
        
        sc.close();
    }
}
