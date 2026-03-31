import java.util.*;
class CartItem {
    String itemName;
    double price;
    int quantity;
    void addItem(int qty) {
        quantity = quantity + qty;
        System.out.println("Added "+qty+" of "+itemName+" to the cart.");
    }
    void removeItem(int qty) {
        if (qty <= quantity) {
            quantity = quantity-qty;
            System.out.println("Removed "+qty+" of "+itemName+" from the cart.");
        } else {
            System.out.println("Cannot remove more items than present in the cart.");
        }
    }
    double calculateTotalCost(){
        return price * quantity;
    }
    void displayCart() {
        System.out.println("Item: "+itemName+", Price: "+price+", Quantity: "+quantity);
    }
}
public class ShoppingCart {
    public static void main(String[] args) {
        Scanner ob = new Scanner(System.in);
        CartItem item = new CartItem();
        System.out.println("Enter item name");
        item.itemName = ob.nextLine();
        System.out.println("Enter item price");
        item.price = ob.nextDouble();
        System.out.println("Enter initial quantity");
        item.quantity = ob.nextInt();
        item.displayCart();
        System.out.println("Enter quantity to add ");
        int addQty = ob.nextInt();
        item.addItem(addQty);
        System.out.println("Enter quantity to remove");
        int removeQty = ob.nextInt();
        item.removeItem(removeQty);
        System.out.println("Total cost: "+item.calculateTotalCost());
    }
}