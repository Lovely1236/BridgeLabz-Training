package inventoryManagement;

class Product {
  private int productId;
  private String productName;
  private int quantity;

  Product(int productId, String productName, int quantity) {
    this.productId = productId;
    this.productName = productName;
    this.quantity = quantity;
  }

  public int getProductId() {
    return productId;
  }

  public int getQuantity() {
    return quantity;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductId(int productId) {
    this.productId = productId;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

}