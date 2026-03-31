package FutureLogistic;
import java.util.*;

public class UserInterface {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the Goods Transport details");
        String input=sc.nextLine();

        GoodsTransport gt=Utility.parseDetails(input);

        if(gt==null) {
            return;
        }

        String type=Utility.findObjectType(gt);

        System.out.println("Transporter id : "+gt.getTransportId());
        System.out.println("Date of transport : "+gt.getTransportDate());
        System.out.println("Rating of the transport : "+gt.getTransportRating());

        if(type.equals("BrickTransport")) {
            BrickTransport bt=(BrickTransport)gt;
            System.out.println("Quantity of bricks : "+bt.getBrickQuantity());
            System.out.println("Brick price : "+bt.getBrickPrice());
            System.out.println("Vehicle for transport : "+bt.vehicleSelection());
            System.out.println("Total charge : "+bt.calculateTotalCharge());
        } else if(type.equals("TimberTransport")) {
            TimberTransport tt=(TimberTransport)gt;
            System.out.println("Type of the timber : "+tt.getTimberType());
            System.out.println("Timber price per kilo : "+tt.getTimberPrice());
            System.out.println("Vehicle for transport : "+tt.vehicleSelection());
            System.out.println("Total charge : "+tt.calculateTotalCharge());
        }
    }
}