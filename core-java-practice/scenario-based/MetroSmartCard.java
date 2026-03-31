import java.util.Scanner;
public class MetroSmartCard{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter initial Smart Card balance: ₹");
        double bal = sc.nextDouble();
        while(bal>0){
            System.out.print("\nEnter distance travelled in km (-1 to quit): ");
            int dist = sc.nextInt();
            if(dist==-1){            // Exit condition
                System.out.println("Thank you for using Delhi Metro 🚇");
                break;
            }
            double fare = (dist <= 5) ? 20 :
                          (dist <= 15) ? 40 : 60;             // Fare calculation using ternary operator
            if(bal>=fare){
                bal -= fare;
                System.out.println("Fare charged: ₹" + fare);
                System.out.println("Remaining balance: ₹" + bal);
            }else{
                System.out.println("Insufficient balance! Please recharge.");
                break;
            }
        }
        System.out.println("\nCard balance exhausted or session ended.");
        sc.close();
    }
}
