import java.util.*;
public class FindAllMultiples {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

     //Number should be between 1 and 100
     
        if(number>0 && number<=100){
            
            for (int i = 100; i >= 1; i--) {
                if (number%i == 0) {
                    System.out.print(number + " ");
                }
            }
        }
        sc.close();
    }
}   