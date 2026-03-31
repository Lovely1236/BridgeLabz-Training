import java.util.Scanner;
public class MovieTicketBooking{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        char continueBooking = 'y';   // ✅ FIX HERE
    do{
    int tikPrice = 0; // ticket price
    int sPrice = 0;   // snacks price
    System.out.println("\nSelect Movie Type from which you want to waste your time:");
    int mType = sc.nextInt();
    switch(mType){
        case 1: tikPrice = 500; break;
        case 2: tikPrice = 250; break;
        case 3: tikPrice = 160; break;
        default:
            System.out.println("Invalid movie type!");
            continue;
    }
    System.out.println("Select Seat Type:");
    int seatType = sc.nextInt();
    if(seatType == 1){
        tikPrice += 100;
    } 
    else if(seatType == 2){
        tikPrice += 50;
    } 
    else{
        System.out.println("Invalid seat type!");
        continue;
    }
    System.out.print("Do you want snacks? (yes/no): ");
    String snacksChoice = sc.next();
    if (snacksChoice.equalsIgnoreCase("yes")) {
        sPrice = 80;
    }
    int totalAmount = tikPrice + sPrice;
    System.out.println("Total Amount: ₹" + totalAmount);
    System.out.print("Book ticket for another customer? (y/n): ");
    continueBooking = sc.next().charAt(0);
} 
while(continueBooking == 'y' || continueBooking == 'Y');
        sc.close(); 
    }
}
