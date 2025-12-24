import java.util.*;
public class TrigonometricCalculator {
    public static double[] calculateTrigonometricFunctions(double angleInDegrees) {
        double angleInRadians = Math.toRadians(angleInDegrees);
        double sineValue = Math.sin(angleInRadians);
        double cosineValue = Math.cos(angleInRadians);
        double tangentValue = Math.tan(angleInRadians);
        return new double[] { sineValue, cosineValue, tangentValue };
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter angle in degrees: ");
        double angle = sc.nextDouble();
        double[] result = calculateTrigonometricFunctions(angle);
        System.out.println("Sine value   : " + result[0]);
        System.out.println("Cosine value : " + result[1]);
        System.out.println("Tangent value: " + result[2]);
        sc.close();
    }
}