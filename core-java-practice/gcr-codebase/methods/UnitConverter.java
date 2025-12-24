import java.util.*;
public class UnitConverter {
    public double convertKmToMiles(double km) {
        double km2miles = 0.621371;
        double miles = km * km2miles;
        return miles;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the distance in kilometers: ");
        double km = sc.nextDouble();
        UnitConverter unitConverter = new UnitConverter();
        double miles = unitConverter.convertKmToMiles(km); 
        System.out.println("Distance in miles: " + miles);
        System.out.print("Enter the distance in Meters: ");
        double meters = sc.nextDouble();
        double kilo = unitConverter.convertMilesToKm(km); 
        System.out.println("Distance in Km: " + kilo);
        double feet = unitConverter.convertMeterToFeet(meters); 
        System.out.println("Distance in feet: " + feet);
        double meter = unitConverter.convertFeetToMeter(feet); 
        System.out.println("Distance in meters: " + meter);
        sc.close();
    }
    public double convertMilesToKm(double miles){
        double km=miles*1.60934;
        return km;
    }
    public double convertMeterToFeet(double meters){
        double feet=meters*3.28084;
        return feet;
    }
    public double convertFeetToMeter(double feet){
        double meters=feet*3.28084;
        return meters;
    }
}