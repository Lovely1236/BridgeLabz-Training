import java.util.Scanner;

public class CalcTotalPrice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double unitPrice;
        unitPrice = sc.nextDouble();

        int qty;
        qty = sc.nextInt();

        double totalPrice;


        totalPrice = unitPrice * qty;

        System.out.println("The total  price is INR " + totalPrice +
                           " if the quantity " + qty +
                           " and unit price is INR " + unitPrice);
    }
}
