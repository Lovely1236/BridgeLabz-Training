 package BridgeLabz-Training.oops-practice.scneario-based.digitalWalletSystem;

class AddMoney extends Wallet implements Operation {
   private int amount;

  AddMoney(int id, int balance, int amount) {
     super(id, balance);
     this.amount = amount;
   }

  public int getAmount() {
    return amount;
  }

   public void setAmount(int amount) {
     this.amount = amount;
   }

   @Override
   public void addMoney() {
     int balance = getBalance() + amount;
     setBalance(balance);
     System.out.println("Balance added Successfully..");
   }

   void details() {
     super.details();
     addMoney();
   }
}