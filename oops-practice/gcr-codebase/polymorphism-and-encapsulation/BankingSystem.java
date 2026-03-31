// Interface
interface Lonable {
  void applyForLoan();

  void calculateEligibility();
}

// Abstract
abstract class Banking {
  private int accountNumber;
  private String holderName;
  private int balance;

  public Banking(int accountNumber, String holderName, int balance) {
    this.accountNumber = accountNumber;
    this.holderName = holderName;
    this.balance = balance;
  }

  // Abstract method
  abstract void calculateInterest();

  // Getters and Setters
  public int getAccountNumber() {
    return accountNumber;
  }

  public String getHolderName() {
    return holderName;
  }

  public int getBalance() {
    return balance;
  }

  public void setBalance(int balance) {
    this.balance = balance;
  }

  // Concrete methods with logic to update the state
  void deposit(int amount) {
    this.balance += amount; // Actually update the balance variable
    System.out.println(amount + " deposited. New Balance: " + balance);
  }

  void withdrawal(int amount) {
    if (amount <= balance) {
      this.balance -= amount;
      System.out.println(amount + " withdrawn. Remaining Balance: " + balance);
    } else {
      System.out.println("Insufficient balance!");
    }
  }
}

class SavingAccount extends Banking implements Lonable {
  private int age;

  // Fixed constructor to include age
  public SavingAccount(int accountNumber, String holderName, int balance, int age) {
    super(accountNumber, holderName, balance);
    this.age = age;
  }

  @Override
  public void applyForLoan() {
    System.out.println("Loan application submitted for Saving Account holder: " + getHolderName());
  }

  @Override
  public void calculateEligibility() {
    if (age >= 18 && getBalance() > 5000) {
      System.out.println("Eligible for Loan (Saving Account).");
    } else {
      System.out.println("Not eligible for loan.");
    }
  }

  @Override
  void calculateInterest() {
    double interest = getBalance() * 0.04; // 4% interest
    System.out.println("Savings Interest: " + interest);
  }
}

class CurrentAccount extends Banking implements Lonable {
  public CurrentAccount(int accountNumber, String holderName, int balance) {
    super(accountNumber, holderName, balance);
  }

  @Override
  public void applyForLoan() {
    System.out.println("Business loan application initiated for: " + getHolderName());
  }

  @Override
  public void calculateEligibility() {
    if (getBalance() > 10000) {
      System.out.println("Eligible for Business Loan.");
    } else {
      System.out.println("Maintain higher balance for loan eligibility.");
    }
  }

  @Override
  void calculateInterest() {
    System.out.println("Current Accounts usually have 0% interest.");
  }
}

public class BankingSystem {
  public static void main(String[] args) {
    SavingAccount savings = new SavingAccount(101, "Shivam", 6000, 21);
    CurrentAccount business = new CurrentAccount(202, "Aman", 15000);
    Banking[] accounts = { savings, business };

    System.out.println("--- Starting Banking Operations ---");

    for (Banking acc : accounts) {
      System.out.println("\nAccount Holder: " + acc.getHolderName());
      acc.deposit(2000);
      acc.calculateInterest();
      if (acc instanceof Lonable) {
        Lonable loanAccount = (Lonable) acc;
        loanAccount.calculateEligibility();
        loanAccount.applyForLoan();
      }

      System.out.println("Final Balance: " + acc.getBalance());
    }
    System.out.println("\n--- Testing Withdrawal ---");
    savings.withdrawal(10000);
    business.withdrawal(5000);
  }
}