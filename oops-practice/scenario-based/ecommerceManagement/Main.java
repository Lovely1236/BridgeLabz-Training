package ecommerceManagement;

import java.util.*;

public class Main {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    Product[] products = {
        new Product(1, "Rice", 100),
        new Product(2, "Wheat", 200),
        new Product(3, "Sugar", 250)
    };

    List<Cart> cart = new ArrayList<>();
    Customer customer = new NormalCustomer("Rahul", 101);

    while (true) {
      System.out.println("\n1 Display Products");
      System.out.println("2 Add to Cart");
      System.out.println("3 Checkout & Bill");
      System.out.println("0 Exit");
      int n = sc.nextInt();

      if (n == 1) {
        for (Product p : products) {
          p.displayDetails();
        }
      }

      else if (n == 2) {
        System.out.print("Enter product name: ");
        String pName = sc.next();

        boolean found = false;
        for (Product p : products) {
          if (p.getName().equalsIgnoreCase(pName)) {
            cart.add(new Cart(p));
            System.out.println("Added to cart");
            found = true;
            break;
          }
        }
        if (!found)
          System.out.println("Product not found");
      }

      else if (n == 3) {
        System.out.println("Choose payment: 1 Card | 2 UPI | 3 Wallet");
        int pay = sc.nextInt();

        Checkout checkout = new Checkout(pay);
        checkout.generateBill();

        Bill bill = new Bill(cart, customer);
        bill.printBill();
      }

      else if (n == 0) {
        System.out.println("Thank you!");
        break;
      }

      else {
        System.out.println("Invalid choice");
      }
    }
  }
}