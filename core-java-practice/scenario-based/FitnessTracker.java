import java.util.*;
public class FitnessTracker {

     public static void main(String[] args){
         
         Scanner sc = new Scanner(System.in);
         

         System.out.print("Enter your weight in kilograms: ");
         double weight = sc.nextDouble();
         

         System.out.print("Enter your height in meters: ");
         double height = sc.nextDouble();

         
         double bmi = weight / (height * height);
         
         System.out.printf("Your BMI is: %.2f\n", bmi);
         
         if (bmi <= 18.4) {
             System.out.println("Underweight");
         } 
         else if (bmi >= 18.5 && bmi <= 24.9) {
             System.out.println("Normal");
         } 
         else if (bmi >= 25.0 && bmi < 39.9) {
             System.out.println("Overweight");
         } 
         else {
             System.out.println("Obese");
         }
         
         sc.close();
     }
}
