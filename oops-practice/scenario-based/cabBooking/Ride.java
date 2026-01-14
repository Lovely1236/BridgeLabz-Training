package cabBooking;

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