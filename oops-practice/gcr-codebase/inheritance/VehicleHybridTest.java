interface Refuelable{
    void refuel();
}
class Vehicle{
    int maxSpeed;
    String model;

    Vehicle(int maxSpeed,String model){
        this.maxSpeed=maxSpeed;
        this.model=model;
    }
}
class ElectricVehicle extends Vehicle{
    ElectricVehicle(int maxSpeed,String model){
        super(maxSpeed,model);
    }
    void charge(){
        System.out.println("Charging");
    }
}
class PetrolVehicle extends Vehicle implements Refuelable{
    PetrolVehicle(int maxSpeed,String model){
        super(maxSpeed,model);
    }
    public void refuel(){
        System.out.println("Refueling");
    }
}
public class VehicleHybridTest{
    public static void main(String[] args){
        PetrolVehicle p=new PetrolVehicle(180,"Honda");
        p.refuel();
    }
}