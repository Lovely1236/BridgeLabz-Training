import java.util.*;
public class WindChillTemperature {
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        System.out.println("Enter the Temperature");
        double temp=ob.nextDouble();
        System.out.println("Enter the Wind Speed");
        double windSpeed=ob.nextDouble();
        WindChillTemperature obj=new WindChillTemperature();
        System.out.println(obj.calculateWindChill(temp,windSpeed));
        ob.close();
    }
    public double calculateWindChill(double temp, double windSpeed){
        double windChill=35.74 + 0.6215 *temp + (0.4275*temp - 35.75) * Math.pow(windSpeed,0.16);
        return windChill;
    }
}