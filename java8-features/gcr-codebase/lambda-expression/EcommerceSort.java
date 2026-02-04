package lambda_expression;
import java.util.*;

class Product {
    String name;
    double price;
    double rating;
    double discount;

    Product(String name, double price, double rating, double discount) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.discount = discount;
    }

    public String toString() {
        return name + " Price:" + price + 
               " Rating:" + rating + 
               " Discount:" + discount;
    }
}

public class EcommerceSort {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();

        products.add(new Product("Laptop", 800, 3.5, 1));
        products.add(new Product("Phone", 5000, 4.7, 10));
        products.add(new Product("Tablet", 30000, 2.2, 20));

       
        products.sort((p1, p2) -> Double.compare(p1.price, p2.price));
        System.out.println("Sorted by Price:");
        products.forEach(System.out::println);

     
        products.sort((p1, p2) -> Double.compare(p2.rating, p1.rating));
        System.out.println("\nSorted by Rating:");
        products.forEach(System.out::println);
    }
}
