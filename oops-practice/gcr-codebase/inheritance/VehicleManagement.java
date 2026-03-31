
class Vehicle {
    String fuelType;
    int maxSpeed;

    Vehicle(String fuelType, int maxSpeed) {
        this.fuelType = fuelType;
        this.maxSpeed = maxSpeed;
    }

    void displayInfo() {
        System.out.println("\n----------------------------");
        System.out.println("Vehicle speed is -: " + maxSpeed);
        System.out.println("Vehicle fuelType is -: " + fuelType);

    }
}

// car
class Car extends Vehicle {
    int seatCapacity;

    Car(String fuelType, int maxSpeed, int seatCapacity) {
        super(fuelType, maxSpeed);
        this.seatCapacity = seatCapacity;
    }

    @Override 
    void displayInfo() {
        super.displayInfo();
        System.out.println("Seat Capacity of car: " + seatCapacity);
    }
}

// truck
class Truck extends Vehicle {
    int seatCapacity;

    Truck(String fuelType, int maxSpeed, int seatCapacity) {
        super(fuelType, maxSpeed);
        this.seatCapacity = seatCapacity;
    }

    @Override 
    void displayInfo() {
        super.displayInfo();
        System.out.println("Seat Capacity of Truck: " + seatCapacity);
    }
}

// motercylcce
class MoterCylcle extends Vehicle {
    int seatCapacity;

    MoterCylcle(String fuelType, int maxSpeed, int seatCapacity) {
        super(fuelType, maxSpeed);
        this.seatCapacity = seatCapacity;
    }

    @Override 
    void displayInfo() {
        super.displayInfo();
        System.out.println("Seat Capacity of MoterCycle: " + seatCapacity);
    }
}

// Main class to run the code
public class VehicleManagement {
    public static void main(String[] args) {

        Car c = new Car("Petrol", 80, 4);
        Truck t = new Truck("Diesel", 110, 8);
        MoterCylcle m = new MoterCylcle("Petrol", 150, 2);

        c.displayInfo();
        t.displayInfo();
        m.displayInfo();
    }
}