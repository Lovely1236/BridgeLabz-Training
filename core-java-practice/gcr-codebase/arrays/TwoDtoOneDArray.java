
import java.util.Scanner;

public class TwoDtoOneDArray{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int col = sc.nextInt();
        

        int[][] matrix = new int[rows][col];
        

        System.out.println("Enter matrix elements---> ");
        for(int i = 0;i< rows;i++){
            
            for (int j = 0;j< col;j++){
                
                matrix[i][j] = sc.nextInt();
            }
        }


        // Create 1D array
        int[] array= new int[rows*col];
        int indx = 0;
        

        // Copy 2D array into 1D array
        for(int i = 0;i<rows;i++){
            
               for(int j = 0;j<columns;j++){
                
                  array[indx] = matrix[i][j];
                
                indx++;
            }
        }

        // Displaying 1D array
        
        
        for(int i = 0;i< array.length;i++){

            System.out.print(array[i] + " ");
            
        }

        sc.close();
    }
}
