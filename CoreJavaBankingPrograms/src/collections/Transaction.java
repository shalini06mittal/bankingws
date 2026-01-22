package collections;

import java.time.LocalDate;

public class Transaction {
    private String transactionId;
    private int accountNumber;
    private String type;  // DEPOSIT, WITHDRAWAL, TRANSFER
    private double amount;
    private LocalDate date;
    private String description;

    public Transaction(String transactionId, int accountNumber, String type,
                       double amount, String description) {
        this.transactionId = transactionId;
        this.accountNumber = accountNumber;
        this.type = type;
        this.amount = amount;
        this.date = LocalDate.now();
        this.description = description;
    }

    // Getters
    public String getTransactionId() { return transactionId; }
    public int getAccountNumber() { return accountNumber; }
    public String getType() { return type; }
    public double getAmount() { return amount; }
    public LocalDate getDate() { return date; }
    public String getDescription() { return description; }

    @Override
    public String toString() {
        return String.format("[%s] %s | %s | $%.2f | %s",
                transactionId, date, type, amount, description);
    }

}
