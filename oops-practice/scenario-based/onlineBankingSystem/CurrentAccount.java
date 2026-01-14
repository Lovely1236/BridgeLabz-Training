package onlineBankingSystem;

class CurrentAccount extends Account implements Transfer {

    private int balance;

    CurrentAccount(long accountNumber, String name, int balance) {
        super(accountNumber, name);
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public void addMoney(int amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }
        balance += amount;
        System.out.println("Money added: " + amount);
        System.out.println("Total balance after adding money: " + balance);
    }

    @Override
    public void withdrawMoney(int amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient Balance...");
            return;
        }
        balance -= amount;
        System.out.println("Money withdrawn: " + amount);
        System.out.println("Remaining balance: " + balance);
    }

    void displayAccountDetails() {
        System.out.println("This is Current Account");
        System.out.println("Name: " + getName());
        System.out.println("Account Number: " + getAccountNumber());
        System.out.println("Balance: " + balance);
        System.out.println("=========================");
    }
}