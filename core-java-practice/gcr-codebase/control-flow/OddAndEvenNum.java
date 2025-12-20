import java.*;
public class OddAndEvenNum {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();
        for(int i=1; i<=number; i++) {

            if(number % 2 == 0) {
            System.out.println("The number is even");
        } 
        else {
            System.out.println("The number is odd");
        }
        }
        
        sc.close();
    }
}