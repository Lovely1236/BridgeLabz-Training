package ecommerceManagement;

class Checkout implements Billing {
  private int choice;

  Checkout(int choice) {
    this.choice = choice;
  }

  @Override
  public void generateBill() {
    if (choice == 1)
      card();
    else if (choice == 2)
      upi();
    else if (choice == 3)
      wallet();
    else
      System.out.println("Invalid payment option");
  }

  public void card() {
    System.out.println("Payment done using Card");
  }

  public void upi() {
    System.out.println("Payment done using UPI");
  }

  public void wallet() {
    System.out.println("Payment done using Wallet");
  }
}