package scenario_based;
import java.util.*;
class Customer {
    String name;
    List<String> items;
    Customer(String name){
        this.name=name;
        this.items=new ArrayList<>();
    }
}
class CheckoutSystem {
    Queue<Customer> queue=new LinkedList<>();
    HashMap<String,Integer> priceMap=new HashMap<>();
    HashMap<String,Integer> stockMap=new HashMap<>();
    public void addItem(String item,int price,int stock){
        priceMap.put(item,price);
        stockMap.put(item,stock);
    }
    public void addCustomer(Customer customer){
        queue.add(customer);
    }
    public void processBilling(){
        while(!queue.isEmpty()){
            Customer current=queue.poll();
            int total=0;
            System.out.println("Customer: "+current.name);
            for(String item:current.items){
                if(priceMap.containsKey(item) && stockMap.get(item)>0){
                    int price=priceMap.get(item);
                    total+=price;
                    stockMap.put(item,stockMap.get(item)-1);
                    System.out.println(item+" -> "+price+" (Stock Left: "+stockMap.get(item)+")");
                }else{
                    System.out.println(item+" -> Out of Stock");
                }
            }
            System.out.println("Total Bill: "+total);
        }
    }
}
public class SmartCheckout {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        CheckoutSystem system=new CheckoutSystem();
        System.out.print("Enter number of items in store: ");
        int n=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n;i++){
            System.out.print("Enter item name: ");
            String item=sc.nextLine();
            System.out.print("Enter price: ");
            int price=sc.nextInt();
            System.out.print("Enter stock: ");
            int stock=sc.nextInt();
            sc.nextLine();
            system.addItem(item,price,stock);
        }
        System.out.print("Enter number of customers: ");
        int c=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<c;i++){
            System.out.print("Enter customer name: ");
            String name=sc.nextLine();
            Customer customer=new Customer(name);
            System.out.print("Enter number of items for "+name+": ");
            int count=sc.nextInt();
            sc.nextLine();
            for(int j=0;j<count;j++){
                System.out.print("Enter item "+(j+1)+": ");
                customer.items.add(sc.nextLine());
            }
            system.addCustomer(customer);
        }
        system.processBilling();
    }
}