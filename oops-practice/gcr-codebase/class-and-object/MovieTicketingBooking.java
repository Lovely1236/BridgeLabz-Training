import java.util.*;
class MovieTicket {
    String movieName;
    String seatNumber;
    double price;
    boolean isBooked = false;
    void bookTicket(String movieName, String seatNumber, double price) {
        if (isBooked) {
            System.out.println("House full!!! sorry..... Ticket already booked");
            return;
        }
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.price = price;
        isBooked = true;
        System.out.println("Ticket booked for movie: "+movieName);
        System.out.println("Seat Number: "+seatNumber);
    }
    void displayTicketDetails() {
        if (!isBooked) {
            System.out.println("Ticket have not booked yet....");
            return;
        }
        System.out.println("Price:" + price);
        System.out.println("Ticket booked for movie: "+movieName);
        System.out.println("Seat Number: "+seatNumber);
        System.out.println("Price: "+price);
    }
}
public class MovieTicketBooking{
    public static void main(String[] args) {
        Scanner ob = new Scanner(System.in);
        MovieTicket ticket = new MovieTicket();
        ticket.displayTicketDetails();
        System.out.println("Enter movie name");
        String movieName = ob.nextLine();
        System.out.println("Enter seat number");
        String seatNumber = ob.nextLine();
        System.out.println("Enter ticket price");
        double price = ob.nextDouble();
        ticket.bookTicket(movieName, seatNumber, price);
        ticket.displayTicketDetails();
    }
}