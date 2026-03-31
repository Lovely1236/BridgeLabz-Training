package ecommerceManagement;
interface Billing {
  void generateBill();

  void card();

  void upi();

  void wallet();
}

interface Generate {
  void printBill();
}