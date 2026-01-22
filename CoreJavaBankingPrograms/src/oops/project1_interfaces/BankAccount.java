package oops.project1_interfaces;

public class BankAccount {
    private int accountNumber;
    private String accountHolderName;

    private double balance;
    private boolean isActive;

    public BankAccount() {
        System.out.println("Bank Account Default constructor");
        this.isActive = true;
    }

    public BankAccount(int accountNumber, String accountHolderName, double balance) {
        System.out.println("Bannk Account Parameterized constructor");
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
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

    public void debit(double amount) {
        balance -= amount;
    }

    public void credit(double amount) {
        balance += amount;
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

}
