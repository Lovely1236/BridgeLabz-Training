import java.util.*;
public class BMICalculator {
    public static void calculateBMI(double[][] data) {
        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];    
            double heightCm = data[i][1]; 
            double heightMeter = heightCm / 100;
            double bmi = weight / (heightMeter * heightMeter);
            data[i][2] = bmi;
        }
    }
    public static String getBMIStatus(double bmi) {
        if (bmi <= 18.4) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            return "Normal";
        } else if (bmi >= 25.0 && bmi <= 39.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] persons = new double[10][3];
        System.out.println("Enter Weight (kg) and Height (cm) for 10 persons:");
        for (int i = 0; i < persons.length; i++) {
            System.out.println("Person " + (i + 1));
            System.out.print("Weight (kg): ");
            persons[i][0] = sc.nextDouble();
            System.out.print("Height (cm): ");
            persons[i][1] = sc.nextDouble();
        }
        calculateBMI(persons);
        System.out.println("BMI REPORT");
        System.out.println("Weight(kg) Height(cm) BMI Status");
        for (int i = 0; i < persons.length; i++) {
            double bmi = persons[i][2];
            String status = getBMIStatus(bmi);
            System.out.println(persons[i][0] + " " +persons[i][1] + " " +bmi + " " +status);
        }
        sc.close();
    }
}