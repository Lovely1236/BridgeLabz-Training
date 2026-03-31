import java.util.*;
public class GreatestFactoRNumWhile {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int counter = 1;
        int greatestFactor = 1;


        if(number>0){


            while(counter <= number) {
                if (number % counter == 0) {
                    greatestFactor = counter;
                }

                counter++;
            }
            
            System.out.println("The greatest factor of " + number + " is " + greatestFactor);
        }
        else{
            System.out.println("Please enter a positive integer greater than 0.");
        }
        sc.close();
    }
}