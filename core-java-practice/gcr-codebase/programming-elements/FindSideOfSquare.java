import java.util.Scanner;

public class FindSideOfSquare {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double perim;
        perim = input.nextDouble();

        double side;
        side = perim / 4;

        System.out.println("The length of the side is " + side +
                           " whose perimeter is " + perim);
    }
}
