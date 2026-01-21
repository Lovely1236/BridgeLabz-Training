package generics;

import java.util.*;
abstract class WarehouseItem {
    String name;
    WarehouseItem(String name){
        this.name=name;
    }
}
class Electronics extends WarehouseItem {
    Electronics(String name){
        super(name);
    }
}
class Groceries extends WarehouseItem {
    Groceries(String name){
        super(name);
    }
}
class Furniture extends WarehouseItem {
    Furniture(String name){
        super(name);
    }
}
class Storage<T extends WarehouseItem> {
    List<T> items=new ArrayList<>();
    public void addItem(T item){
        items.add(item);
    }
    public List<T> getItems(){
        return items;
    }
    public static void displayAll(List<? extends WarehouseItem> list){
        System.out.println("\nWarehouse Items:");
        for(WarehouseItem item:list){
            System.out.println("-> "+item.name);
        }
    }
}
public class SmartWarehouseManagement {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Storage<WarehouseItem> storage=new Storage<>();
        System.out.print("Enter number of items: ");
        int n=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n;i++){
            System.out.print("Enter item type(Electronics/Groceries/Furniture): ");
            String type=sc.nextLine();
            System.out.print("Enter item name: ");
            String name=sc.nextLine();
            if(type.equalsIgnoreCase("Electronics")){
                storage.addItem(new Electronics(name));
            }else if(type.equalsIgnoreCase("Groceries")){
                storage.addItem(new Groceries(name));
            }else if(type.equalsIgnoreCase("Furniture")){
                storage.addItem(new Furniture(name));
            }
        }
        Storage.displayAll(storage.getItems());
    }
}