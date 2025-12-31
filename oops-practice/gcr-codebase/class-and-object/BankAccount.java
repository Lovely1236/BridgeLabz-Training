class BankAccount {
    public long accountNumber;
    protected String accountHolder;
    private double balance;
    

   
    // Constructor
    public BankAccount(long accountNumber, String accountHolder, double balance){
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }



    // Public methods for balance
    public double getBalance(){



        return balance;
    }

    public void setBalance(double balance){

        this.balance = balance;
    }
}


class SavingsAccount extends BankAccount{
    public SavingsAccount(long accountNumber, String accountHolder, double balance){

        super(accountNumber, accountHolder, balance);
    }



    public void showAccountDetails(){


        System.out.println("Account Number: " + accountNumber); // public
        System.out.println("Account Holder: " + accountHolder); // protected
        System.out.println("Balance: ₹" + getBalance());        // private via method
    }
}
