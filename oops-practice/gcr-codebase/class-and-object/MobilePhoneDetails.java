import java.util.*;
class MobilePhone{
    String brand;
    String model;
    double price;
    void takeInput(Scanner ob){
        System.out.print("Enter mobile brand: ");
        brand = ob.nextLine();
        System.out.print("Enter mobile model: ");
        model = ob.nextLine();
        System.out.print("Enter mobile price: ");
        price = ob.nextDouble();
        ob.nextLine();
    }
    void displayDetails(){
        System.out.println("Brand of mobile: " + brand);
        System.out.println("Model of mobile: " + model);
        System.out.println("Price of mobile: " + price);
        System.out.println("------------------------------");
    } }
public class MobilePhoneDetails{
    public static void main(String[] args){
        Scanner ob = new Scanner(System.in);
        System.out.print("Enter number of mobile phones: ");
        int count = ob.nextInt();
        ob.nextLine();
        MobilePhone[] phones = new MobilePhone[count];
        for(int i = 0;i<count;i++){
            System.out.println("Enter details for Mobile Phone " + (i+1));
            phones[i] = new MobilePhone();
            phones[i].takeInput(ob);
        }
        for(MobilePhone phone : phones){
            phone.displayDetails();
        }
    }
}