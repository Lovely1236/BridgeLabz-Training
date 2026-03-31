import java.util.Scanner;
import java.util.Random;
public class NumberGuessingGame{
    public static int generateGuess(int low, int high){    // Method to generate a guess within range
        Random rand = new Random();
        return rand.nextInt(high - low + 1) + low;
    }
    public static String getFeedback(Scanner sc){    // Method to get user feedback
        System.out.print("Enter feedback (high / low / correct): ");
        return sc.nextLine().toLowerCase();
    }
    public static int[] updateRange(String feedback, int guess, int low, int high){    // Method to update range based on feedback
        if(feedback.equalsIgnoreCase("high")){
            high = guess - 1;
        } 
        else if(feedback.equalsIgnoreCase("low")){
            low = guess + 1;
        }
        return new int[]{low, high};
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int lo = 1;
        int hi = 100;
        boolean isCorrect = false;
        System.out.println("Think of a number between 1 and 100.");
        System.out.println("I will try to guess it!");
        while (!isCorrect && lo <= hi){
            int guess = generateGuess(lo, hi);
            System.out.println("My guess is: " + guess);
            String feedback = getFeedback(sc);
            if(feedback.equals("correct")){
                System.out.println("Yay! I guessed your number correctly 🎉");
                isCorrect = true;
            } 
            else if(feedback.equals("high") || feedback.equals("low")){
                int[] range = updateRange(feedback, guess, lo, hi);
                lo = range[0];
                hi = range[1];
            } 
            else{
                System.out.println("Invalid feedback! Please enter high, low, or correct.");
            }
        }
        sc.close();
    }
}
