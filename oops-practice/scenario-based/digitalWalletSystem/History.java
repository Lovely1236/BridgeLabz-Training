package BridgeLabz-Training.oops-practice.scneario-based.digitalWalletSystem;
class History {
       private int amount;
       private String operation;

   History(int amount, String operation) {
     this.amount = amount;
     this.operation = operation;
   }

   public int getAmount() {
     return amount;
   }

   public String getOperation() {
     return operation;
   }
}