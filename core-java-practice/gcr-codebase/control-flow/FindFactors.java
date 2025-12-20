import java.util.*;
public class FindFactors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();


        // Finding factors of the given number using for loop
       if(number>0){
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                System.out.print(i + " ");
            }
        }
    }
    else{
        System.out.println("Please enter a positive integer greater than 0.");
        
    }
    sc.close();
}
}