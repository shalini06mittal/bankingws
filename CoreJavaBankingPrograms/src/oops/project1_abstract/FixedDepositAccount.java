package oops.project1_abstract;

public class FixedDepositAccount extends BankAccount {

    private double interestRate;
    private int tenureMonths;
    private java.time.LocalDate maturityDate;
    private double maturityAmount;

    public FixedDepositAccount(int accountNumber, String accountHolderName, double amount,
                               double interestRate, int tenureMonths) {
        super(accountNumber, accountHolderName, amount);
        this.interestRate = interestRate;
        this.tenureMonths = tenureMonths;
        this.maturityDate = java.time.LocalDate.now().plusMonths(tenureMonths);
        this.maturityAmount = calculateMaturityAmount();
        System.out.println("FixedDepositAccount constructor called");
    }

    @Override
    public double calculateInterest() {
        return getBalance() * 0.065 * tenureMonths * 12; // 6.5% * tenure
    }
    private double calculateMaturityAmount() {
        // Compound interest: A = P(1 + r/n)^(nt)
        // For simplicity: monthly compounding
        double monthlyRate = interestRate / 12;
        return getBalance() * Math.pow(1 + monthlyRate, tenureMonths);
    }

    // Override to prevent withdrawals before maturity
    @Override
    public void debit(double amount) {
        if (java.time.LocalDate.now().isBefore(maturityDate)) {
            System.out.println("Cannot withdraw before maturity date: " + maturityDate);
            System.out.println("Early withdrawal penalty applies. Contact bank.");
        }

        //Allow full withdrawal on maturity
        if (amount == maturityAmount) {
            setBalance(0);
            System.out.printf("FD matured. Amount: $%.2f%n", amount);
        }
        else
            System.out.println("Can only withdraw full maturity amount");
    }

    // Override to prevent deposits
    @Override
    public void credit(double amount) {
        System.out.println("Cannot deposit into Fixed Deposit account");
    }

    @Override
    public String toString() {
        return "FixedDepositAccount{" +
                "interestRate=" + interestRate +
                ", tenureMonths=" + tenureMonths +
                ", maturityDate=" + maturityDate +
                ", maturityAmount=" + maturityAmount +
                "} " + super.toString();
    }

    // Getters
    public java.time.LocalDate getMaturityDate() { return maturityDate; }
    public double getMaturityAmount() { return maturityAmount; }

}
