
import java.util.*;
public class CoffeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("☕☕☕☕Welcome to The Coffee Counter ☕☕☕☕");
        System.out.println("Here is our Coffee Menu:");
        System.out.println("1. Espresso - ₹165");
        System.out.println("2. Latte - ₹210");
        System.out.println("3. Cappuccino - ₹120");
        System.out.println("4. Americano - ₹155");
        System.out.println("5. Mocha - ₹320");
        System.out.println("6. Macchiato - ₹185");
        System.out.println("7. Flat White - ₹130");
        System.out.println("8. Ristretto - ₹175");
        System.out.println("9. Affogato - ₹195");
        System.out.println("10. Cortado - ₹200");

        while (true) {
            System.out.print("\nHello, Please Tell us your coffee choice (Espresso/Latte/Cappuccino/and may options or exit): ");
            
            String coffeeType = sc.next();

            // Exit condition
            if (coffeeType.equalsIgnoreCase("exit")) {
                System.out.println("Coffee Counter Closed ☕");
                break;
            }

            System.out.print("May I know the quantity of " + coffeeType + ": ");
            int quantity = sc.nextInt();

            double price = 0;

            // Switch case for coffee prices

            switch (coffeeType.toLowerCase()) {

                case "espresso":
                    price = 165;
                    break;

                case "latte":
                    price = 210;
                    break;

                case "cappuccino":
                    price = 120;
                    break;

                case "americano":
                    price = 155;
                    break;

                case "mocha":
                    price = 320;
                    break;

                case "macchiato":
                    price = 185;
                    break;

                case "flat white":
                    price = 130;
                    break;

                case "ristretto":
                    price = 175;
                    break;

                case "affogato":
                    price = 195;
                    break;  

                case "cortado":
                    price = 200;
                    break;  
                
                default:
                    System.out.println("Sorry,We Don't Serve That!");
                    continue;
         }
            
            final double GST_RATE = 0.18; // fixed GST rate of 18%

            // Bill calculation
            double total = price * quantity;
            double gst = total * GST_RATE;
            double finalAmount = total + gst;

            // Output bill for the coffee order
            System.out.println("\n--- Bill Details ---");
            System.out.println("Coffee Type : " + coffeeType);
            System.out.println("Quantity    : " + quantity);
            System.out.println("Total Bill  : ₹" + total);
            System.out.println("GST (18%)   : ₹" + gst);
            System.out.println("Final Amount: ₹" + finalAmount);
            System.out.println("---------------------\nEnjoy your Coffee! ☕");
        }
        sc.close();
    }
}
