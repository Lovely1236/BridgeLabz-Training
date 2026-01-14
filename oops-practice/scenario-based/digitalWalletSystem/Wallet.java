package digitalWalletSystem;

class Wallet {
   private int id;
   private int balance;

  Wallet(int id, int balance) {
    this.id = id;
    this.balance = balance;
  }

 public int getId() {
    return id;
  }

  public int getBalance() {
    return balance;
  }

  public void setBalance(int balance) {
    this.balance = balance;
  }
    System.out.println("Balance -:" + balance);
  }
 }