import java.util.*;

public class CountNumberFor {
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);

       int counter= sc.nextInt();
         

       // Using for loop to count down from counter to 1
       for (int i = counter; i >= 1; i--) {
           System.out.println(i);
       }

       sc.close();
   } 
}
