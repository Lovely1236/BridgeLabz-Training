import java.util.*;

public class SumOfAllNumbers{
   
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        double[] numbers = new double[10];

        double total = 0.0;
        int index = 0;

        


        while(true){
            if(index==10) break;
            System.out.print("\n Enter a number---> ");

            double value = sc.nextDouble();

            // Break if value is 0 or negative

            if(value <= 0){
                
                break;
            }


            
            // Storing value in array

            numbers[index]= value;
            index++;
        }

        
        for (int i = 0; i < index; i++) {
            
            total += numbers[i];
            
        }

        // Display total
        System.out.println("\nSum of all numbers = " + total);

        sc.close();
    }
}
