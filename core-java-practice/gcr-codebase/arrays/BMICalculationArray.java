import java.util.*;
public class BMICalculationArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of people: ");
        int numPeople = scanner.nextInt();
        
        double[] weights = new double[numPeople];
        double[] heights = new double[numPeople];
         double[] bmi = new double[numPeople];
        String[] status = new String[numPeople];
        
        for (int i = 0; i < numPeople; i++) {
            System.out.print("Enter weight in pounds for person " + (i + 1) + ": ");
            weights[i] = scanner.nextDouble();
            
            System.out.print("Enter height in inches for person " + (i + 1) + ": ");
            heights[i] = scanner.nextDouble();
        }
        
        System.out.println("BMI values for each person:");
        for (int i = 0; i < n; i++) {
            bmi[i] = weight[i] / (height[i] * height[i]);

            if (bmi[i] <= 18.4) {
                status[i] = "Underweight";
            } else if (bmi[i] <= 24.9) {
                status[i] = "Normal";
            } else if (bmi[i] <= 39.9) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }

        for (int i = 0; i < numPeople; i++) {
            System.out.println("Person " + (i + 1) + ": BMI = " + bmi[i] + ", Status = " + status[i]);
        }
    }
}
