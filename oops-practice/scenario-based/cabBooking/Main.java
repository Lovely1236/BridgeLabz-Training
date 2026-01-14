package cabBooking;

public class Main {
  public static void main(String[] args) {

    Driver d1 = new Driver("Lovely, 15, true);
    User u1 = new User("Mahima", 1);

    try {
      Ride ride1 = new Ride(u1, d1, 10, 4);
      ride1.displayBill();
    } catch (Exception e) {
      System.out.println("Error: Driver is not available.");
    }
  }
}