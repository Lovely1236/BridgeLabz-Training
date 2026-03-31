import java.text.ChoiceFormat;
import java.util.*;
public class Main {
   public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     Wallet wallet = new Wallet(1, 50000);

     List<History> history = new ArrayList<>();

     while (true) {
       System.out.print(
           "Enter your choice -: 1 for Add Money | 2 for withdraw | 3 for fundtransfer | 4 for history | 5 for exit -:");
       int choice = sc.nextInt();

       if (choice == 1) {
         System.out.print("Enter the amount to add -: ");
         int amount = sc.nextInt();

         AddMoney add = new AddMoney(
             wallet.getId(),
             wallet.getBalance(),
             amount);

         add.addMoney();

         history.add(new History(amount, "Add Money"));

       } else if (choice == 2) {
        System.out.print("Enter the amount to withdraw -: ");
         int amount = sc.nextInt();

         WithdrawMoney withdrawMoney = new WithdrawMoney(wallet.getId(),
             wallet.getBalance(),
             amount);
         withdrawMoney.withdrawMoney();

         history.add(new History(amount, "Withdraw"));

       } else if (choice == 3) {
         System.out.print("Enter the Receiver id -: ");
         int id = sc.nextInt();

         System.out.print("Enter the amount -: ");
         int amount = sc.nextInt();

         if (amount > wallet.getBalance()) {
           System.out.println("Insufficient balance...");
         } else {
           int newBalance = wallet.getBalance() - amount;
           wallet.setBalance(newBalance);

           history.add(new History(amount, "Transfer"));
           System.out.println("Balance transferred successfully");
           System.out.println("Remaining Balance: " + wallet.getBalance());
         }
       } else if (choice == 4) {
         System.out.println("AMOUNT" + "||" + "OPERTION");
         for (History history2 : history) {
           System.out.println(history2.getAmount() + " || " + history2.getOperation());
         }
       } else if (choice == 5) {
         System.out.println("Thank You");
         break;
       } else {
         System.out.println("Invalid Choice");
         break;
       }

     }

   }
 }