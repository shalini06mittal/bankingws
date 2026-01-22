package oops.project1_abstract;

public class SavingsAccount extends BankAccount {
    private double interestRate;
    private int withdrawalCount;
    private static final int FREE_WITHDRAWALS = 4;
    private static final double WITHDRAWAL_FEE = 5.0;

    public SavingsAccount(int accountNumber, String accountHolderName, double balance, double interestRate) {
        super(accountNumber, accountHolderName, balance);  // Call parent constructor
        this.interestRate = interestRate;
        this.withdrawalCount = 0;
        System.out.println("SavingsAccount constructor called");
    }

    // Additional method specific to SavingsAccount
    public void addInterest() {
        double interest = getBalance() * interestRate / 12;  // Monthly interest
        setBalance(getBalance()+interest);
        System.out.printf("Interest added: $%.2f (Rate: %.2f%%)%n", interest, interestRate * 100);
        System.out.printf("New balance: $%.2f%n", getBalance());
    }

    @Override
    public void debit(double amount) {
        withdrawalCount++;
        if (withdrawalCount > FREE_WITHDRAWALS) {
            System.out.println("Withdrawal fee: $" + WITHDRAWAL_FEE);
            amount += WITHDRAWAL_FEE;
        }
        super.debit(amount);
    }

    public void resetWithdrawalCount() {
        withdrawalCount = 0;
        System.out.println("Monthly withdrawal count reset");
    }

    @Override
    public double calculateInterest() {
        return getBalance() * 0.04; // 4% annually
    }
    @Override
    public String toString() {
        return "SavingsAccount{" +
                "interestRate=" + interestRate +
                ", withdrawalCount=" + withdrawalCount +
                "} " + super.toString();
    }
}
