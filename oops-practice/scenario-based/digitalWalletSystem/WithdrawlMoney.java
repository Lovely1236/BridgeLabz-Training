package BridgeLabz-Training.oops-practice.scneario-based.digitalWalletSystem;

class WithdrawMoney extends Wallet implements Operation2 {

   private int amount;

   WithdrawMoney(int id, int balance, int amount) {
     super(id, balance);
     this.amount = amount;
   }

   public int getAmount() {
     return amount;
   }

   @Override
   public void withdrawMoney() {

     if (amount > getBalance()) {
       System.out.println("Insufficient balance....");
       return;
     } else {

       int bill = getAmount() - amount;
       System.out.println("Withdrawl Successful....");
     }
   }

   void details() {
     super.details();
     withdrawMoney();
   }
}