public class Product{
  static int discount;
  public String productName;
  int price;
  int quantity;
  final String productId;

  // constructor
  Product(int discount, String productName, int price, int quantity, String productId){
    Product.discount = discount;
    this.productName = productName;
    this.price = price;
    this.quantity = quantity;
    this.productId = productId;

  }

  // static getter
  public static int getDiscount(){

    return discount;
  }


  // static updater
  public static void updateDiscount(int newDiscount){
    discount = newDiscount;
  }


  // instanceof usage
  public static void displayDetails(Product p){
    if(p instanceof Product){
      double discountedPrice = p.price - (p.price * (discount / 100.0));
      System.out.println("Product Id -: " + p.productId);
      System.out.println("Product Name -: " + p.productName);
      System.out.println("Price -: " + p.price);
      System.out.println("Quantity -: " + p.quantity);
      System.out.println("Discount -: " + discount + "%");
      System.out.println("Price after discount -: " + discountedPrice);
    }
  }
  public static void main(String[] args){
    Product p = new Product(10, "MACBook", 112000, 1, "P001");

    updateDiscount(15); // modify shared discount
    displayDetails(p);
  }
}