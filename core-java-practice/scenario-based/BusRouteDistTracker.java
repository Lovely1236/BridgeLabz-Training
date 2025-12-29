import java.util.Scanner;
public class BusRouteDistTracker{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int totalDist = 0;
        int stopDist = 2;   // each stop adds 2 km
        char ch;
        System.out.println("---- Welcome to Bus Route Distance Tracker ----");
        while (true) {
            totalDist += stopDist;
            System.out.println("Bus reached next stop.");
            System.out.println("Total distance travelled: " + totalDist + " km");
            System.out.print("Do you want to get off? (y/n): ");
            ch = sc.next().charAt(0);
            if (ch == 'y' || ch == 'Y') {
                System.out.println("Passenger got off the bus.");
                break;
            }
        }
        System.out.println("Final distance travelled: " + totalDist + " km");
        sc.close();
    }
}
