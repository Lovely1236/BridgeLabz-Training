
import java.*;
public class PositiveNegativeOrZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];

        for(int i=0;i<arr.length;i++){

            arr[i]=sc.nextInt();
        }
        
        for(int i=0;i<arr.length;i++){

            if(arr[i]>0){
//If number is positive then check even or odd

                System.out.println("Positive");

                if(arr[i]%2==0){
                      
                    System.out.println("Even");
                }
                else{
                     
                    System.out.println("Odd");
            }
        }

            else if(arr[i]<0){
                
                System.out.println("Negative");
            }
            else{
                
                System.out.println("Zero");
            }
        }


        //Compre first and last elements of the array 

        if(arr[0]>arr[arr.length-1]){
           
            System.out.println("First element is greater than last element");
        }
        else if(arr[0]<arr[arr.length-1]){
           
            System.out.println("Last element is greater than first element");
        }
        else{
            
            System.out.println("First and last elements are equal");
        }
        sc.close();
    }
}