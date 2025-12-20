import java.util.*;
public class BMICalculationArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of people: ");
        int numPeople = scanner.nextInt();
        
        double[] weights = new double[numPeople];
        double[] heights = new double[numPeople];
        
        for (int i = 0; i < numPeople; i++) {
            System.out.print("Enter weight in pounds for person " + (i + 1) + ": ");
            weights[i] = scanner.nextDouble();
            
            System.out.print("Enter height in inches for person " + (i + 1) + ": ");
            heights[i] = scanner.nextDouble();
        }
        
        System.out.println("BMI values for each person:");
        for (int i = 0; i < numPeople; i++) {
            double bmi = (weights[i] / (heights[i] * heights[i])) * 703;
            System.out.println("Person " + (i + 1) + ": " + bmi);
        }
    }
}
