package onlineBankingSystem;

class Account {
    private long accountNumber;
    private String name;

    Account(long accountNumber, String name) {
        this.accountNumber = accountNumber;
        this.name = name;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }
}