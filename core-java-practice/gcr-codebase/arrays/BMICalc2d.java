import java.util.Scanner;
public class BMICalc2d {
    public static void main(String[] args) {
         System.out.print("Enter number of persons: ");
        int number = sc.nextInt();

        // 2D array to store weight, height, BMI
        // index 0 -> weight, 1 -> height, 2 -> BMI
        double[][] personData = new double[number][3];
         // Array to store weight status
        String[] weightStatus = new String[number];
          
         for (int i = 0; i < number; i++) {
            System.out.println("\nEnter details for Person " + (i + 1));

            // Weight input with validation
            while (true) {
                System.out.print("Enter weight (kg): ");
                double weight = sc.nextDouble();
                if (weight > 0) {
                    personData[i][0] = weight;
                    break;
                }
                System.out.println("Invalid input! Weight must be positive.");
            }

            while(true) {
                System.out.print("Enter height (m): ");
                double height = sc.nextDouble();
                if (height > 0) {
                    personData[i][1] = height;
                    break;
                }
                System.out.println("Invalid input! Height must be positive.");
            }
    }
        // Calculate BMI and determine weight status
        for (int i = 0; i < number; i++) {
            double weight = personData[i][0];
            double height = personData[i][1];
            double bmi = weight / (height * height);
            personData[i][2] = bmi;

            if (bmi < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (bmi >= 18.5 && bmi <= 24.9) {
                weightStatus[i] = "Normal weight";
            } else if (bmi >= 25 && bmi <= 29.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obesity";
            }
        }

        // Display results
        System.out.println("\nBMI Calculation Results:");
        for (int i = 0; i < number; i++) {
            System.out.printf("Person %d: Weight = %.2f kg, Height = %.2f m, BMI = %.2f, Weight Status = %s%n",
                    i + 1, personData[i][0], personData[i][1], personData[i][2], weightStatus[i]);
        }
    }
}
