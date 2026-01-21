package generics;
import java.util.*;
abstract class ProductCategory {
    String categoryName;
    ProductCategory(String name){
        this.categoryName=name;
    }
}
class BookCategory extends ProductCategory {
    BookCategory(){
        super("Books");
    }
}
class ClothingCategory extends ProductCategory {
    ClothingCategory(){
        super("Clothing");
    }
}
class GadgetCategory extends ProductCategory {
    GadgetCategory(){
        super("Gadgets");
    }
}
class Product<T extends ProductCategory> {
    String name;
    double price;
    T category;
    Product(String name,double price,T category){
        this.name=name;
        this.price=price;
        this.category=category;
    }
    public void display(){
        System.out.println("Product: "+name+" | Price: "+price+" | Category: "+category.categoryName);
    }
}
public class MarketPlace {
    public static <T extends Product<?>> void applyDiscount(T product,double percent){
        product.price=product.price-(product.price*percent/100);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter product name: ");
        String name=sc.nextLine();
        System.out.print("Enter price: ");
        double price=sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter category(Book/Clothing/Gadget): ");
        String type=sc.nextLine();
        Product<?> product=null;
        if(type.equalsIgnoreCase("Book")){
            product=new Product<>(name,price,new BookCategory());
        }else if(type.equalsIgnoreCase("Clothing")){
            product=new Product<>(name,price,new ClothingCategory());
        }else if(type.equalsIgnoreCase("Gadget")){
            product=new Product<>(name,price,new GadgetCategory());
        }
        product.display();
        System.out.print("Enter discount percentage: ");
        double d=sc.nextDouble();
        applyDiscount(product,d);
        System.out.println("After Discount:");
        product.display();
    }
}