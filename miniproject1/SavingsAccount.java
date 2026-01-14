package miniproject1;

class SavingsAccount extends BankAccount implements FileOperations {

    public SavingsAccount(int accNo, String name, double bal) {
        super(accNo, name, bal);
    }

    // Method overriding
    @Override
    public void withdraw(double amount) {
        if (amount > balance)
            System.out.println("Insufficient balance");
        else
            balance -= amount;
    }

    @Override
    void calculateInterest() {
        double interest = balance * 0.04;
        balance += interest;
    }

    // File storage
    @Override
    public void saveToFile() {
        try (java.io.FileWriter fw = new java.io.FileWriter("accounts.txt", true)) {
            fw.write(getAccountNumber() + "," + getHolderName() + "," + balance + "\n");
        } catch (Exception e) {
            System.out.println("File write error");
        }
    }

    @Override
    public void readFromFile() {
        try (java.util.Scanner sc = new java.util.Scanner(new java.io.File("accounts.txt"))) {
            while (sc.hasNextLine())
                System.out.println(sc.nextLine());
        } catch (Exception e) {
            System.out.println("File read error");
        }
    }
}

