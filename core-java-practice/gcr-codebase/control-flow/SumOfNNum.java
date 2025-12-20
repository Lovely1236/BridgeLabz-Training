import java.util.*;

public class SumOfNNum {    

    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int sum = 0; 

        for(int i = 1; i <= n; i++) { 
               
            sum = sum + i;    
        }

        if(n>=0)
                System.out.println("Sum of " + n + " natural number is " + sum); 
        System.out.println("The number " + n + "  is not a natural number");   
        sc.close(); 
    }
    
}
