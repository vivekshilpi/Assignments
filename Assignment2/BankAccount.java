package Assignment2;

public class BankAccount implements Banking, Customer {

    private int accNo;
    private String name;
    private double balance;

    public BankAccount(int accNo, String name, double balance) {
        this.accNo = accNo;
        this.name = name;
        this.balance = balance;
    }

    @Override
    public void deposit(double amount) throws Exception {
        if (amount <= 0)
            throw new Exception("Invalid deposit amount");
        balance += amount;
    }

    @Override
    public void withdraw(double amount) throws Exception {
        if (amount <= 0)
            throw new Exception("Invalid withdrawal amount");
        if (amount > balance)
            throw new Exception("Insufficient balance");
        balance -= amount;
    }

    @Override
    public void showDetails() {
        System.out.println("Account No: " + accNo);
        System.out.println("Name: " + name);
        System.out.println("Balance: " + balance);
    }

    public static void main(String[] args) {
        BankAccount acc = new BankAccount(1, "Sanya", 3000);

        try {
            acc.deposit(1000);
            acc.withdraw(500);
            acc.withdraw(5000); // exception
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        acc.showDetails();
    }
}

// Interfaces (same file)
interface Banking {
    void deposit(double amount) throws Exception;
    void withdraw(double amount) throws Exception;
}

interface Customer {
    void showDetails();
}

