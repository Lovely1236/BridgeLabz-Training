public class CarRental{

  String customerName;
  String carModel;
  int rentalDays;

  // constructor
  CarRental(String customerName, String carModel, int rentalDays){
    this.customerName = customerName;
    this.carModel = carModel;
    this.rentalDays = rentalDays;
  }

  // calling
  void displayRent(){
    System.out.println("Customer Name -: " + customerName);
    System.out.println("Car Model-: " + carModel);
    System.out.println("Rental Days -: " + rentalDays);
    System.out.println("Total Bill -:" + (rentalDays * 300));

  }

  // main
  public static void main(String[] args){

    CarRental car = new CarRental("Lovely", "BMW", 10);

  }
}