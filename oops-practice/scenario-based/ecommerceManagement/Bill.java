package ecommerceManagement;
import java.util.*;
class Bill implements Generate {
  private List<Cart> cart;
  private Customer customer;

  Bill(List<Cart> cart, Customer customer) {
    this.cart = cart;
    this.customer = customer;
  }

  public void printBill() {
    int total = 0;
    System.out.println("\n----- FINAL BILL -----");
    customer.displayDetails();
    for (Cart c : cart) {
      c.getProduct().displayDetails();
      total += c.getProduct().getPrice();
    }
    System.out.println("Total Amount: " + total);
  }
}