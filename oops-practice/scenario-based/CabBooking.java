import java.util.*;

interface Calculate {
  double calculateTotalFare();
}

// for driver
class Driver {
  private String name;
  private int pricePerKm;
  private boolean isAvailable;

  Driver(String name, int pricePerKm, boolean isAvailable) {
    this.name = name;
    this.pricePerKm = pricePerKm;
    this.isAvailable = isAvailable;
  }

  public boolean isAvailable() {
    return isAvailable;
  }

  public int getPricePerKm() {
    return pricePerKm;
  }

  public String getName() {
    return name;
  }
}

// for user
class User {
  private String name;
  private int id;

  User(String name, int id) {
    this.name = name;
    this.id = id;
  }

  // getter
  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

}

class Ride implements Calculate {

  private final User user;
  private final Driver driver;
  private final int distance;
  private final int vehicleType;

  Ride(User user, Driver driver, int distance, int vehicleType) throws Exception {
    if (!driver.isAvailable()) {
      throw new Exception("DriverBusyException");
    }
    this.user = user;
    this.driver = driver;
    this.distance = distance;
    this.vehicleType = vehicleType;
  }
  @Override
  public double calculateTotalFare() {
    double basePrice = driver.getPricePerKm() * distance;
    return switch (vehicleType) {
      case 2 -> basePrice + 100;
      case 4 -> basePrice + 150;
      default -> 0;
    };
  }
  void displayBill() {
    System.out.println("--- Bill Details ---");
    System.out.println("User: " + user.getName());
    System.out.println("Driver: " + driver.getName());
    System.out.println("Distance: " + distance + " km");
    System.out.printf("Total Amount: %.2f%n", calculateTotalFare());
  }
}
public class CabBooking {
  public static void main(String[] args) {
    Driver d1 = new Driver("Lovely", 15, true);
    User u1 = new User("Mahima", 1);
    // try - catch block
    try {
      Ride ride1 = new Ride(u1, d1, 10, 4);
      ride1.displayBill();
    } catch (Exception e) {
      System.out.println("Error: Driver is not available.");
    }
  }
}