import java.util.Scanner;

public class FindAreaOfTriangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double base;
        base = input.nextDouble();

        double height;
        height = input.nextDouble();

        double areaInches;
        double areaCm;




        areaInches = 0.5 * base * height;

        areaCm = areaInches * 6.4516;

        System.out.println("The area of the triangle in inches is " + areaInches +
                           " and in square centimeters  is" + areaCm );
    }
}
