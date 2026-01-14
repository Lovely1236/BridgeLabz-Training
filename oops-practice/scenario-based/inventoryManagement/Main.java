package inventoryManagement;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    List<Product> product = new ArrayList<>();

    product.add(new Product(1, "Rice", 100));
    product.add(new Product(2, "Wheat", 200));
    product.add(new Product(3, "Barley", 300));

    while (true) {
      System.out.print(
          "Enter the choice -: 1 for display product | 2 for add product | 3 for search product | 4 for delete product | 5 for update Product | 6 for exit -: ");
      int choice = sc.nextInt();

      if (choice == 1) {
        for (Product product2 : product) {
          System.out
              .println("Product Id -:" + product2.getProductId() + " Product Name -: " + product2.getProductName());
        }
      } else if (choice == 2) {
        System.out.print("Enter the product id -: ");
        int id = sc.nextInt();
        System.out.print("Enter the product Name -: ");
        String name = sc.next();
        System.out.print("Enter the product Quantity-: ");
        int quantity = sc.nextInt();

        for (int i = 0; i < product.size(); i++) {
          product.add(new Product(id, name, quantity));
          System.out.println("Prodcut added successfully......");
        }

      } else if (choice == 3) {
        System.out.print("Enter the product id -: ");
        int id = sc.nextInt();
        boolean isFound = false;

        for (Product product2 : product) {
          if (product2.getProductId() == id) {
            System.out.println("Product found!!!! ");
            isFound = true;
            break;
          }
        }
        if (!isFound) {
          System.out.println("No such type of product");
        }

      } else if (choice == 4) {
        System.out.print("Enter the product id -: ");
        int id = sc.nextInt();
        boolean isFoundn = false;

        for (int i = 0; i < product.size(); i++) {
          if (product.get(i).getProductId() == id) {
            product.remove(i);
            isFoundn = true;
            System.out.println("Product removed successfully........");
          }
        }
        if (!isFoundn) {
          System.out.println("No such type of product....");
        }
      } else if (choice == 5) {
        System.out.print("Enter the product id -: ");
        int id = sc.nextInt();
        boolean isFound = false;

        for (int i = 0; i < product.size(); i++) {
          if (product.get(i).getProductId() == id) {

            isFound = true;
            System.out.println("Product found!!!!\n");

            System.out.print(
                "Choose update option: 1 Update ID | 2 Update Name | 3 Update Quantity | 4 Update All -: ");
            int x = sc.nextInt();

            if (x == 1) {
              System.out.print("Enter new id -: ");
              int newId = sc.nextInt();
              product.get(i).setProductId(newId);
            }

            else if (x == 2) {
              System.out.print("Enter new name -: ");
              sc.nextLine();
              String newName = sc.nextLine();
              product.get(i).setProductName(newName);
            }

            else if (x == 3) {
              System.out.print("Enter new quantity -: ");
              int qty = sc.nextInt();
              product.get(i).setQuantity(qty);
            }

            else if (x == 4) {
              System.out.print("Enter new id -: ");
              int newId = sc.nextInt();
              sc.nextLine();
              System.out.print("Enter new name -: ");
              String newName = sc.nextLine();
              System.out.print("Enter new quantity -: ");
              int qty = sc.nextInt();

              product.get(i).setProductId(newId);
              product.get(i).setProductName(newName);
              product.get(i).setQuantity(qty);
            }

            System.out.println("Product updated successfully!");
            break;
          }
        }

        if (!isFound) {
          System.out.println("No such type of product");
        }
      } else if (choice == 6) {
        System.out.println("Thanks You............");
        break;
      } else {
        System.out.println("Invalid choice ");
        break;
      }

    }

  }
}