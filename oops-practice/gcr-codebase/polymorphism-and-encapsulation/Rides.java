// Interface for GPS functionality
interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

// Abstract class
abstract class Vehicle {

    // Encapsulated fields
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    // Getters only (Encapsulation)
    public String getVehicleId() {
        return vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    // Concrete method
    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Rate per Km: ₹" + ratePerKm);
    }

    // Abstract method
    abstract double calculateFare(double distance);
}

// Car class
class Car extends Vehicle implements GPS {

    private String location;

    Car(String id, String driver, double rate) {
        super(id, driver, rate);
    }

    @Override
    double calculateFare(double distance) {
        return getRatePerKm() * distance + 50; // base charge
    }

    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String newLocation) {
        location = newLocation;
    }
}

// Bike class
class Bike extends Vehicle implements GPS {

    private String location;

    Bike(String id, String driver, double rate) {
        super(id, driver, rate);
    }

    @Override
    double calculateFare(double distance) {
        return getRatePerKm() * distance; // no base charge
    }

    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String newLocation) {
        location = newLocation;
    }
}

// Auto class
class Auto extends Vehicle implements GPS {

    private String location;

    Auto(String id, String driver, double rate) {
        super(id, driver, rate);
    }

    @Override
    double calculateFare(double distance) {
        return (getRatePerKm() * distance) + 20; // auto charge
    }

    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String newLocation) {
        location = newLocation;
    }
}

// Main class
public class Ride {

    public static void main(String[] args) {

        Vehicle v1 = new Car("C101", "Rahul", 15);
        Vehicle v2 = new Bike("B201", "Aman", 8);
        Vehicle v3 = new Auto("A301", "Suresh", 12);

        calculateRide(v1, 10);
        calculateRide(v2, 10);
        calculateRide(v3, 10);
    }

    // Polymorphic method
    static void calculateRide(Vehicle vehicle, double distance) {

        vehicle.getVehicleDetails();
        System.out.println("Distance: " + distance + " km");
        System.out.println("Fare: ₹" + vehicle.calculateFare(distance));

        if (vehicle instanceof GPS) {
            GPS g = (GPS) vehicle;
            g.updateLocation("City Center");
            System.out.println("Current Location: " + g.getCurrentLocation());
        }

        System.out.println("----------------------------------");
    }
}