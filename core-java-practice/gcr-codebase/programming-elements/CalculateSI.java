public class CalculateSI {
    public static void main(String[] args) {

        double p = 1120.0;

        double r = 2.5;

        double t = 2.0;

        double SI = (p * r * t) / 100;

        System.out.println("Principal: " + p);

        System.out.println("Rate of Interest: " + r);

        System.out.println("Time (years): " + t);
        
        System.out.println("Simple Interest: " + SI);
    }
}
