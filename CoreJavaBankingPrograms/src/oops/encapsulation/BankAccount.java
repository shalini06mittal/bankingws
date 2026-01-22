package oops.encapsulation;

public class BankAccount {
    private int accountNumber;
    private String accountHolderName;

    private double balance;
    private boolean isActive;

    public BankAccount() {
        System.out.println("Bank Account Default constructor");
        this.isActive = true;
    }

    // Getters
    public int getAccountNumber() {
        return accountNumber;
    }
    public String getAccountHolderName() {
        return accountHolderName;
    }
    public double getBalance() {
        return balance;
    }
    public boolean isActive() {
        return isActive;
    }

    public void setAccountHolderName(String accountHolderName) {
        if (accountHolderName != null && !accountHolderName.trim().isEmpty()) {
            this.accountHolderName = accountHolderName;
        } else {
            System.out.println("Invalid name");
        }
    }
    // Setters
    public void setBalance(double balance) {
        if(balance < 1000){
            System.out.println("Need to have minimum balance 10000");
        }
        else
            this.balance = balance;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber=" + accountNumber +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", balance=" + balance +
                ", isActive=" + (isActive ? "Yes" : "No ") +
                '}';
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
