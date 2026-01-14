package miniproject1;

abstract class BankAccount {

    private int accountNumber;
    private String holderName;
    protected double balance;

    public BankAccount(int accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Encapsulation
    public int getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    // Method Overloading
    public void deposit(double amount) {
        balance += amount;
    }

    public void deposit(double amount, String note) {
        balance += amount;
        System.out.println(note);
    }

    // Method Overriding (to be overridden)
    public void withdraw(double amount) {
        balance -= amount;
    }

    // Abstract method
    abstract void calculateInterest();

    public void displayDetails() {
        System.out.println("Account No: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: ₹" + balance);
    }
}
