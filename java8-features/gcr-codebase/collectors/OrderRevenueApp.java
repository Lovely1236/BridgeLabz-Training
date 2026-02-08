package collectors;
import java.util.*;
import java.util.stream.*;

class Order{
    String customer;
    double amount;
    Order(String customer,double amount){
        this.customer=customer;
        this.amount=amount;
    }
    String getCustomer(){return customer;}
    double getAmount(){return amount;}
}

public class OrderRevenueApp{
    public static void main(String[] args){
        List<Order> orders=Arrays.asList(
            new Order("Rahul",200.5),
            new Order("Rahul",100.0),
            new Order("Aman",300.0)
        );
        Map<String,Double> revenue=orders.stream().collect(Collectors.groupingBy(Order::getCustomer,Collectors.summingDouble(Order::getAmount)));
        System.out.println(revenue);
    }
}