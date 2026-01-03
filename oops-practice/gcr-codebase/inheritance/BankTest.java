class BankAccount{
    String accountNumber;
    double balance;
    BankAccount(String accountNumber,double balance){
        this.accountNumber=accountNumber;
        this.balance=balance;
    }
}
class SavingsAccount extends BankAccount{
    double interestRate;
    SavingsAccount(String acc,double bal,double interestRate){
        super(acc,bal);
        this.interestRate=interestRate;
    }
    void displayAccountType(){
        System.out.println("Savings Account");
    }
}
class CheckingAccount extends BankAccount{
    double withdrawalLimit;
    CheckingAccount(String acc,double bal,double withdrawalLimit){
        super(acc,bal);
        this.withdrawalLimit=withdrawalLimit;
    }
}
class FixedDepositAccount extends BankAccount{
    int tenure;
    FixedDepositAccount(String acc,double bal,int tenure){
        super(acc,bal);
        this.tenure=tenure;
    }
}
public class BankTest{
    public static void main(String[] args){
        BankAccount b=new SavingsAccount("ACC1",5000,4.5);
        ((SavingsAccount)b).displayAccountType();
    }
}