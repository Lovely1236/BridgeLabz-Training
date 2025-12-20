import java.util.Scanner;
public class LargestOfThreeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number1 = sc.nextInt();


        int number2 = sc.nextInt();
        int number3 = sc.nextInt();

        int largest;

        if(number1 >= number2 && number1 >= number3) {
           
            largest = number1;
            System.out.println("Is the first number the largest? Yes");
        } 
        else if(number2 >= number1 && number2 >= number3) {
            
            largest = number2;

            System.out.println("Is the second number the largest? Yes");
        } 
        
        else {
          
            largest = number3;

            System.out.println("Is the third number the largest? Yes");
        }

        sc.close();
    }
}
