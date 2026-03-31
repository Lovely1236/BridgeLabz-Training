import java.util.*;
public class FindBMI {

     public static void main(String[] args){
         
         Scanner sc = new Scanner(System.in);
         

         System.out.print("Enter weight in kilograms: ");
         double weight = sc.nextDouble();
         

         System.out.print("Enter height in meters: ");
         double height = sc.nextDouble();

         // Calculate BMI
         double bmi = weight / (height * height);
         
         System.out.printf("Your BMI is: %.2f\n", bmi);
         
         if (bmi <= 18.4) {
            
            //if BMI is less than or equal to 18.4 then print Underweight
             System.out.println("Underweight");
         } 

         //if BMI is between 18.5 and 24.9 then print Normal
         else if (bmi >= 18.5 && bmi <= 24.9) {
             System.out.println("Normal");
         } 

            //if BMI is between 25.0 and 39.9 then print Overweight
         else if (bmi >= 25.0 && bmi < 39.9) {
             System.out.println("Overweight");
         } 

            //if BMI is greater than or equal to 40.0 then print Obese
         else {
             System.out.println("Obese");
         }
         
         sc.close();
     }
}
