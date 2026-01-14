package cabBooking;

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