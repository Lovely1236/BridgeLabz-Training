import java.util.*;

public class DistInYards {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double distanceFt;
        distanceFt = sc.nextDouble();

        double yards;
        yards = distanceFt / 3;

        double miles;


        miles = yards / 1760;

        System.out.println("The distance in feet is " + distanceFt +
                           " while in yards is " + yards +
                           " and miles is " + miles);
    }
}
