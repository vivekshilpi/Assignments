import java.util.Scanner;

class BankAccount {

    String name;
    int accountNumber;
    double balance;

    // Create account
    void createAccount(Scanner sc) {
        System.out.print("Enter account holder name: ");
        name = sc.nextLine();

        System.out.print("Enter account number: ");
        accountNumber = sc.nextInt();

        System.out.print("Enter initial balance: ");
        balance = sc.nextDouble();

        System.out.println("Account created successfully");
    }

    // Deposit money
    void deposit(Scanner sc) {
        try {
            System.out.print("Enter amount to deposit: ");
            double amount = sc.nextDouble();

            if (amount <= 0)
                throw new Exception("Invalid amount");

            balance = balance + amount;
            System.out.println("Amount deposited successfully");

        } catch (Exception e) {
            System.out.println("Error: Please enter valid amount");
            sc.nextLine();
        }
    }

    // Withdraw money
    void withdraw(Scanner sc) {
        try {
            System.out.print("Enter amount to withdraw: ");
            double amount = sc.nextDouble();

            if (amount > balance)
                throw new Exception("Insufficient balance");

            balance = balance - amount;
            System.out.println("Withdrawal successful");

        } catch (Exception e) {
            System.out.println("Error: Insufficient balance or invalid input");
            sc.nextLine();
        }
    }

    // Balance enquiry
    void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }

    // Display account details
    void displayDetails() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Account Holder: " + name);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}

public class BankManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount();
        int choice;

        account.createAccount(sc);
        sc.nextLine(); // clear buffer

        do {
            System.out.println("\n--- BANK MENU ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Balance Enquiry");
            System.out.println("4. Account Details");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    account.deposit(sc);
                    break;

                case 2:
                    account.withdraw(sc);
                    break;

                case 3:
                    account.checkBalance();
                    break;

                case 4:
                    account.displayDetails();
                    break;

                case 5:
                    System.out.println("Thank you for using bank services");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 5);

        sc.close();
    }
}
