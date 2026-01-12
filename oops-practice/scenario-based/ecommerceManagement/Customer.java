package ecommerceManagement;

abstract class Customer {
  private String name;
  private int id;

  Customer(String name, int id) {
    this.name = name;
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public int getId() {
    return id;
  }

  void displayDetails() {
    System.out.println("Customer: " + name + " (" + id + ")");
  }
}

class NormalCustomer extends Customer {
  NormalCustomer(String name, int id) {
    super(name, id);
  }
}