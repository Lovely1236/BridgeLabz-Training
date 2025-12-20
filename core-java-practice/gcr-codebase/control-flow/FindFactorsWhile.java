import java.util.*;
public class FindFactorsWhile {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int counter = 1;

        if(num>0){

        // Finding factors of the given number using while loop
            while(counter <= num) {
                if (num % counter == 0) {
                    System.out.print(counter + " ");
                }
                counter++;
            }
        }
        else{
            System.out.println("Please enter a positive integer greater than 0.");
        }
        sc.close();
    }
}