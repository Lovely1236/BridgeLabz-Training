import java.util.*;

public class FizzBuzzIArray{
        public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        String[] result = new String[number + 1];


        if(number<= 0){
            
            System.out.println("Please enter a positive integer");
            
            return;
        }
        
        
        for(int i= 0;i<= number;i++){

            if(i==0) {
                
                result[i] = "0";
            } 
            else if(i%3 ==0 && i%5 ==0){
                
                result[i] = "FizzBuzz";
            } 
            else if(i%3 ==0){
                
                result[i] = "Fizz";
            } 
            else if(i%5 ==0){
                
                result[i] = "Buzz";
            } 
            else{
                
                result[i]= String.valueOf(i);
                
            }
        }


        // Print the array results
        System.out.println("\nResults---> ");
        
        for(int i = 1;i<= number;i++){
            
            System.out.println("Position"+i +" = " + result[i]);
        }
        

        sc.close();
    }
}
