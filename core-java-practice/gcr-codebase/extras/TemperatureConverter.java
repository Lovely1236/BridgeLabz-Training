import java.util.Scanner;
public class TemperatureConverter{
    public static double fahrenheitToCelsius(double f){    // Convert Fahrenheit to Celsius
        return (f - 32) * 5 / 9;
    }
    public static double celsiusToFahrenheit(double c){    // Convert Celsius to Fahrenheit
        return (c * 9 / 5) + 32;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("WELCOME to Temperature Converter. Please choose an option:");
        System.out.println("1. Fahrenheit to Celsius");
        System.out.println("2. Celsius to Fahrenheit");
        int ch = sc.nextInt();
        switch (ch){
            case 1:
                System.out.print("Enter temperature in Fahrenheit: ");
                double f = sc.nextDouble();
                System.out.println("Temperature in Celsius: " + fahrenheitToCelsius(f));
                break;
            case 2:
                System.out.print("Enter temperature in Celsius: ");
                double c = sc.nextDouble();
                System.out.println("Temperature in Fahrenheit: " + celsiusToFahrenheit(c));
                break;
            default:
                System.out.println("Invalid choice");
        }
        sc.close();
    }
}
