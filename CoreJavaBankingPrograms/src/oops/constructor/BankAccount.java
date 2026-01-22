package oops.constructor;

public class BankAccount {
    int accountNumber;
    String accountHolderName;

    double balance;
    boolean isActive;

    public BankAccount() {
        System.out.println("Bank Account Default constructor");
    }

    public BankAccount(int accountNumber, String accountHolderName, double balance) {
        System.out.println("Bannk Account Parameterized constructor");
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.isActive = true;
    }

    void displayAccountInfo() {
        System.out.println("\n=== Account Information ===");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + accountHolderName);
        System.out.println("Balance: $" + balance);
        System.out.println("Status: " + (isActive ? "Active" : "Inactive"));
    }

    // Method to deposit money
    double deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("\nDeposited: $" + amount);

        } else {
            System.out.println("Invalid deposit amount");
        }
        return balance;
    }

    // Method to withdraw money
    double withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("\nWithdrawn: $" + amount);

        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            System.out.println("Invalid withdrawal amount");
        }
        return balance;
    }


}
