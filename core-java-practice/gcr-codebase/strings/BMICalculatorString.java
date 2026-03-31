import java.util.Scanner;

public class BMICalculatorString {

    static String[] calculateBMIAndStatus(double weight, double heightCm) {
        double heightMeter = heightCm / 100;
        double bmi = weight / (heightMeter * heightMeter);
        bmi = Math.round(bmi * 100.0) / 100.0;
        String status;
        if (bmi <= 18.4) {
            status = "Underweight";
        } else if (bmi <= 24.9) {
            status = "Normal";
        } else if (bmi <= 39.9) {
            status = "Overweight";
        } else {
            status = "Obese";
        }
        return new String[]{String.valueOf(bmi), status};
    }
    static String[][] generateBMIReport(double[][] data) {
        String[][] report = new String[data.length][4];
        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];
            double height = data[i][1];
            String[] bmiData = calculateBMIAndStatus(weight, height);
            report[i][0] = String.valueOf(height);
            report[i][1] = String.valueOf(weight);
            report[i][2] = bmiData[0];
            report[i][3] = bmiData[1];
        }
        return report;
    }
    static void displayReport(String[][] report) {
        System.out.println("Height(cm)\tWeight(kg)\tBMI\tStatus");
        for (int i = 0; i < report.length; i++) {
            System.out.println(report[i][0] + "\t\t" +report[i][1] + "\t\t" +report[i][2] + "\t" +report[i][3]);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] inputData = new double[10][2];
        for (int i = 0; i < 10; i++) {
            inputData[i][0] = sc.nextDouble();
            inputData[i][1] = sc.nextDouble();
        }
        String[][] bmiReport = generateBMIReport(inputData);
        displayReport(bmiReport);
        sc.close();
    }
}