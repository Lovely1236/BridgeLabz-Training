import java.util.*;

abstract class Product {
    String name;
    double price;
    int quantity;

    Product(String n, double p, int q) {
        name = n;
        price = p;
        quantity = q;
    }

    abstract void display();
    double totalValue() {
        return price * quantity;
    }
}

class Electronics extends Product {
    int warranty;

    Electronics(String n, double p, int q, int w) {
        super(n, p, q);
        warranty = w;
    }

    void display() {
        System.out.println(name + " - Price: " + price + ", Quantity: " + quantity + ", Warranty: " + warranty + " months");
    }
}

class Clothing extends Product {
    String size;

    Clothing(String n, double p, int q, String s) {
        super(n, p, q);
        size = s;
    }

    void display() {
        System.out.println(name + " - Price: " + price + ", Quantity: " + quantity + ", Size: " + size);
    }
}

public class InventorySystem {

    static List<Product> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        while (n-- > 0) {
            String[] input = sc.nextLine().split(", ");

            if (input[0].equals("Electronics")) {
                Product p = new Electronics(
                        input[1],
                        Double.parseDouble(input[2]),
                        Integer.parseInt(input[3]),
                        Integer.parseInt(input[4])
                );
                list.add(p);
                System.out.println("Product added to inventory: " + input[1]);

            } else if (input[0].equals("Clothing")) {
                Product p = new Clothing(
                        input[1],
                        Double.parseDouble(input[2]),
                        Integer.parseInt(input[3]),
                        input[4]
                );
                list.add(p);
                System.out.println("Product added to inventory: " + input[1]);
            }
        }

        System.out.println("Inventory:");
        double total = 0;

        for (Product p : list) {
            p.display();
            total += p.totalValue();
        }

        System.out.printf("Total value of the inventory: %.2f\n", total);
    }
}