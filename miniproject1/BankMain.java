package miniproject1;

import java.util.Scanner;

public class BankMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankAccount account = null;
        int choice;

        try {
            do {
                System.out.println("\n--- BANK MANAGEMENT SYSTEM ---");
                System.out.println("1. Create Account");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Balance Enquiry");
                System.out.println("5. Display Account Details");
                System.out.println("6. Read Accounts From File");
                System.out.println("7. Exit");
                System.out.print("Enter choice: ");

                choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        System.out.print("Account Number: ");
                        int accNo = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Holder Name: ");
                        String name = sc.nextLine();

                        System.out.print("Initial Balance: ");
                        double bal = sc.nextDouble();

                        // Runtime Polymorphism
                        account = new SavingsAccount(accNo, name, bal);
                        ((SavingsAccount) account).saveToFile();

                        System.out.println("Account created successfully");
                        break;

                    case 2:
                        System.out.print("Amount: ");
                        account.deposit(sc.nextDouble(), "Deposit Successful");
                        break;

                    case 3:
                        System.out.print("Amount: ");
                        account.withdraw(sc.nextDouble());
                        break;

                    case 4:
                        System.out.println("Balance: ₹" + account.getBalance());
                        break;

                    case 5:
                        account.displayDetails();
                        break;

                    case 6:
                        ((SavingsAccount) account).readFromFile();
                        break;

                    case 7:
                        System.out.println("Thank you!");
                        break;

                    default:
                        System.out.println("Invalid choice");
                }

            } while (choice != 7);

        } catch (Exception e) {
            System.out.println("Invalid input");
        } finally {
            sc.close();
        }
    }
}

