import java.util.Scanner;

public class HeightConversion {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double heightInCm;
        heightInCm = input.nextDouble();

        double totaInInches;
        totaInInches = heightInCm / 2.54;

        int feet;
        double inches;



        

         feet = (int) (totaInInches / 12);
        inches = totaInInches % 12;

        
        System.out.println("Your Height in cm is " + heightInCm +
                " while in feet is " + feet +
                " and inches is " + inches);
    }
}
