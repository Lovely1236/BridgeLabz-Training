package ecommerceManagement;

class Product {
  private int id;
  private String name;
  private int price;

  Product(int id, String name, int price) {
    this.id = id;
    this.name = name;
    this.price = price;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public int getPrice() {
    return price;
  }

  void displayDetails() {
    System.out.println(id + " | " + name + " | " + price);
  }
}