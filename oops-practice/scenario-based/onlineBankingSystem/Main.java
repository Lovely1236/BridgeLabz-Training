package onlineBankingSystem;

public class Main {

  public static void main(String[] args) {

    System.out.println("===== ONLINE BANKING SYSTEM =====\n");

    // Account creation
    SavingAccount sa = new SavingAccount(1001001L, "Shivam", 5000);
    CurrentAccount ca = new CurrentAccount(2002002L, "Aditya", 3000);

    // Balance check
    sa.displayAccountDetails();
    ca.displayAccountDetails();

    // Add money
    System.out.println("---- Adding Money ----");
    sa.addMoney(2000);
    ca.addMoney(1500);

    // Withdraw money
    System.out.println("\n---- Withdrawing Money ----");
    sa.withdrawMoney(1000);
    ca.withdrawMoney(500);

    // Fund transfer
    System.out.println("\n---- Fund Transfer (Saving → Current) ----");
    int transferAmount = 1500;

    if (sa.getBalance() >= transferAmount) {
      sa.withdrawMoney(transferAmount);
      ca.addMoney(transferAmount);
      System.out.println("Transfer Successful!");
    } else {
      System.out.println("Transfer Failed: Insufficient Balance");
    }

    // Final status
    System.out.println("\n---- Final Account Status ----");
    sa.displayAccountDetails();
    ca.displayAccountDetails();

    System.out.println("===== TRANSACTION COMPLETED =====");
  }
}