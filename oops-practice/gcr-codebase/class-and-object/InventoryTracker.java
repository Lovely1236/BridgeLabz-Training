import java.util.*;
class Item {
    String itemCode;
    String itemName;
    double price;
    void takeInput(Scanner ob) {
        System.out.print("Enter item code: ");
        itemCode = ob.nextLine();
        System.out.print("Enter item name: ");
        itemName = ob.nextLine();
        System.out.print("Enter item price: ");
        price = ob.nextDouble();
        ob.nextLine();
    }
    void displayItem() {
        System.out.println("itemCode : " + itemCode);
        System.out.println("itemPrice : " + price);
        System.out.println("itemName : " + itemName);
        System.out.println("----------------------------");
    }
    double calculateTotalCost(int quantity) {
        return price * quantity;
    }
}
public class InventoryTracker {
    public static void main(String[] args) {
        Scanner ob = new Scanner(System.in);
        System.out.print("Enter number of items: ");
        int numberOfItems = ob.nextInt();
        ob.nextLine();
        Item[] items = new Item[numberOfItems];
        for (int i = 0; i < numberOfItems; i++) {
            System.out.println("Enter details for Item " + (i + 1));
            items[i] = new Item();
            items[i].takeInput(ob);
        }
        for (Item item : items) {
            item.displayItem();
        }
        System.out.print("Enter quantity to calculate total cost: ");
        int quantity = ob.nextInt();
        System.out.print("Select item number (1 to " +numberOfItems+ "): ");
        int choice = ob.nextInt();
        double totalCost = items[choice-1].calculateTotalCost(quantity);
        System.out.println("Total cost for selected item = " + totalCost);
    }
}