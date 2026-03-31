class Order {
    int orderId;
    int orderDate;

    Order(int orderId, int orderDate) {
        this.orderDate = orderDate;
        this.orderId = orderId;
    }

    void getOrderStatus() {
        System.out.println("Order Date is -: " + orderDate);
        System.out.println("Order id is -: " + orderId);
    }
}

// shipped order class
class ShippedOrder extends Order {
    int trackingNumber;

    ShippedOrder(int orderId, int orderDate, int trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    @Override
    void getOrderStatus() {
        super.getOrderStatus();
        System.out.println("The tracking number is -: " + trackingNumber);
    }
}

// Deliverorder class
class Deliverorder extends ShippedOrder {
    int deliverDate;

    Deliverorder(int orderId, int orderDate, int deliverDate) {
        super(orderId, orderDate, deliverDate);
        this.trackingNumber = trackingNumber;
    }

    @Override
    void getOrderStatus() {
        super.getOrderStatus();
        System.out.println("The Deliver Date is -: " + deliverDate);
    }
}

// Main class to run the code
public class RetailOrder {
    public static void main(String[] args) {
        Order order = new Order(1, 22);
        ShippedOrder shippedOrder = new ShippedOrder(2, 23, 2153);
        Deliverorder deliverorder = new Deliverorder(3, 24, 26);

        order.getOrderStatus();
        shippedOrder.getOrderStatus();
        deliverorder.getOrderStatus();
    }
}