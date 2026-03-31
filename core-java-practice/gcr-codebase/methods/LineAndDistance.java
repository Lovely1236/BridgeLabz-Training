import java.util.Scanner;
import java.util.Arrays;

public class LineAndDistance {

    // Method to find Euclidean distance
    public static double findDistance(double x1, double y1,
            double x2, double y2) {

        double dx = Math.pow(x2 - x1, 2);
        double dy = Math.pow(y2 - y1, 2);

        return Math.sqrt(dx + dy);
    }

    // Method to find slope (m) and y-intercept (b)
    // returns array: [m, b]
    public static double[] findLineEquation(double x1, double y1,
            double x2, double y2) {

        double m = (y2 - y1) / (x2 - x1);
        double b = y1 - (m * x1);

        return new double[] { m, b };
    }

    // MAIN METHOD
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input points
        System.out.print("Enter x1: ");
        double x1 = sc.nextDouble();

        System.out.print("Enter y1: ");
        double y1 = sc.nextDouble();

        System.out.print("Enter x2: ");
        double x2 = sc.nextDouble();

        System.out.print("Enter y2: ");
        double y2 = sc.nextDouble();

        // Distance calculation
        double distance = findDistance(x1, y1, x2, y2);
        System.out.println("\nEuclidean Distance = " + distance);

        // Line equation calculation
        if (x2 - x1 == 0) {
            System.out.println("Equation of line: x = " + x1 + " (Vertical Line)");
        } else {
            double[] line = findLineEquation(x1, y1, x2, y2);
            System.out.println("Slope (m): " + line[0]);
            System.out.println("Y-Intercept (b): " + line[1]);
            System.out.println("Equation of Line: y = " + line[0] + "x + " + line[1]);
        }

        sc.close();
    }
}