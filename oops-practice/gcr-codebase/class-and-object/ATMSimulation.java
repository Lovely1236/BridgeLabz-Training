import java.util.*;
class BankAccount{
    String accountHolder;
    String accountNumber;
    double balance;
    void deposit(double amount){
        balance = balance + amount;
        System.out.println("Deposited: " + amount);
        displayBalance();
    }void withdraw(double amount){
        if(amount <= balance){
            balance = balance - amount;
            System.out.println("Withdraw amount is : " + amount);
            displayBalance();
        }
        else{
            System.out.println("Insufficient balance");
        }
    }

    void displayBalance(){
        System.out.println("Current balance: " + balance);
    }
}
public class ATMSimulation{
    public static void main(String[] args){
        Scanner ob = new Scanner(System.in);
        BankAccount account = new BankAccount();
        System.out.print("Enter Account Holder Name: ");
        account.accountHolder = ob.nextLine();
        System.out.print("Enter Account Number: ");
        account.accountNumber = ob.nextLine();
        System.out.print("Enter Initial Balance: ");
        account.balance = ob.nextDouble();
        System.out.println("\t\tState of Chennai");
        account.displayBalance();
        System.out.print("Enter deposit amount: ");
        double depositAmount = ob.nextDouble();
        account.deposit(depositAmount);
        System.out.print("Enter withdraw amount: ");
        double withdrawAmount = ob.nextDouble();
        account.withdraw(withdrawAmount);
        System.out.print("Enter withdraw amount again: ");
        double withdrawAmount2 = ob.nextDouble();
        account.withdraw(withdrawAmount2);
    }
}