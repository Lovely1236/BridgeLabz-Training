import java.util.*;

public class MultiplicationTable {
    
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        int[] table = new int[10];



        // Storing multiplication result from 1 to 10 in array

        for (int i = 1; i <= 10; i++){

            table[i-1] = number * i;
        }



        // Print the stored multiplication table

        for (int i = 0; i < table.length; i++){

            System.out.println(number + " x " + (i+1) + " = " + table[i]);
        }

        
        sc.close();
    }
}
