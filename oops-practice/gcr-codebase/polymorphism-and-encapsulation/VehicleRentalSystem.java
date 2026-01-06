interface Isurable {
  void calculateInsurance();

  void getInsuranceDetails();
}

abstract class Vehicle {
  private int vehicleNumber;
  private int type;
  private int rate;

  public Vehicle(int vehicleNumber, int type, int rate) {
    this.vehicleNumber = vehicleNumber;
    this.type = type;
    this.rate = rate;
  }

  public void getInsuranceDetails() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getInsuranceDetails'");
  }

  public void calculateInsurance() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'calculateInsurance'");
  }

  // Fixed Getters and Setters
  public int getVehicleNumber() {
    return vehicleNumber;
  }

  public void setVehicleNumber(int vehicleNumber) {
    this.vehicleNumber = vehicleNumber;
  }

  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }

  public int getRate() {
    return rate;
  }

  public void setRate(int rate) {
    this.rate = rate;
  }

  abstract void calculateRentalCost(int days);

  void displayCalulateStatus() {
    System.out.println("Vehicle Number: " + vehicleNumber);
    System.out.println("Type: " + type);
    System.out.println("Rate: " + rate);
  }
}

class Car extends Vehicle implements Isurable {
  private int days;
  private int insuranceRate;
  private double calculatedInsurance;

  public Car(int vehicleNumber, int type, int rate, int days, int insuranceRate) {
    super(vehicleNumber, type, rate);
    this.days = days;
    this.insuranceRate = insuranceRate;
  }

  @Override
  void calculateRentalCost(int days) {
    System.out.println("Rental Cost: " + (days * getRate()));
  }

  @Override
  public void calculateInsurance() {
    this.calculatedInsurance = days * insuranceRate;
  }

  @Override
  public void getInsuranceDetails() {
    System.out.println("Insurance Cost: " + calculatedInsurance);
  }

  @Override
  void displayCalulateStatus() {
    super.displayCalulateStatus();
    calculateRentalCost(days);
    calculateInsurance();
    getInsuranceDetails();
  }
}

class Bike extends Vehicle {
  private int days;
  private int insuranceRate;
  private double calculatedInsurance;

  public Bike(int vehicleNumber, int type, int rate, int days, int insuranceRate) {
    super(vehicleNumber, type, rate);
    this.days = days;
    this.insuranceRate = insuranceRate;
  }

  @Override
  void calculateRentalCost(int days) {
    System.out.println("Rental Cost: " + (days * getRate()));
  }

  @Override
  public void calculateInsurance() {
    this.calculatedInsurance = days * insuranceRate;
  }

  @Override
  public void getInsuranceDetails() {
    System.out.println("Insurance Cost: " + calculatedInsurance);
  }

  @Override
  void displayCalulateStatus() {
    super.displayCalulateStatus();
    calculateRentalCost(days);
    calculateInsurance();
    getInsuranceDetails();
  }
}

class Truck extends Vehicle {
  private int days;
  private int insuranceRate;
  private double calculatedInsurance;

  public Truck(int vehicleNumber, int type, int rate, int days, int insuranceRate) {
    super(vehicleNumber, type, rate);
    this.days = days;
    this.insuranceRate = insuranceRate;
  }

  @Override
  void calculateRentalCost(int days) {
    System.out.println("Rental Cost: " + (days * getRate()));
  }

  @Override
  public void calculateInsurance() {
    this.calculatedInsurance = days * insuranceRate;
  }

  @Override
  public void getInsuranceDetails() {
    System.out.println("Insurance Cost: " + calculatedInsurance);
  }

  @Override
  void displayCalulateStatus() {
    super.displayCalulateStatus();
    calculateRentalCost(days);
    calculateInsurance();
    getInsuranceDetails();
  }
}

public class VehicleRentalSystem {
  public static void main(String[] args) {
    Vehicle v1 = new Car(7010, 4, 12, 50, 12);
    v1.displayCalulateStatus();
  }
}