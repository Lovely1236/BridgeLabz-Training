public class ProductInventory{
  String productName;
  int price;
  static int totalProducts = 0;



  // instance method
  void displayProductDetails(){
    System.out.println("Product Name -: " + productName);
    System.out.println("Product Price -: " + price);
  }

  static void displayTotalProducts(){
    System.out.println("Total Products -: " + totalProducts);
  }

  public static void main(String[] args){
    ProductInventory p = new ProductInventory();
    p.productName = "Top";
    p.price = 300;

    ProductInventory.displayTotalProducts();
  }

}