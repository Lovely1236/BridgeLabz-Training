package ecommerceManagement;
class Cart {
  private Product product;

  Cart(Product product) {
    this.product = product;
  }

  public Product getProduct() {
    return product;
  }
}