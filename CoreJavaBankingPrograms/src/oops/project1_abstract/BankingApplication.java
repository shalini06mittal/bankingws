package oops.project1_abstract;

public class BankingApplication {
    public static void main(String[] args) {

        System.out.println("=== Creating Savings Account ===");
        SavingsAccount savings = new SavingsAccount(3001, "Alice Johnson", 5000, 0.04);
        System.out.println();

        System.out.println("\n--- Transactions ---");
        savings.credit(1000);
        savings.debit(500);
        savings.debit(300);  // More withdrawals
        savings.debit(200);
        savings.debit(100);
        System.out.println(savings.getBalance());
        savings.debit(100);  // Should charge fee
        System.out.println(savings.getBalance());
        savings.addInterest();

        System.out.println(savings);

        System.out.println("\n" + "=".repeat(50));
        System.out.println("=== Creating Fixed Deposit Account ===");
        FixedDepositAccount fd = new FixedDepositAccount(3003, "Charlie Brown", 10000, 0.07, 12);
        System.out.println();

        System.out.println(fd);

        System.out.println("\n--- Attempting Transactions ---");
        fd.debit(1000);  // Not allowed
        fd.credit(5000);  // Not allowed before maturity

        // Demonstrating polymorphism
        System.out.println("\n" + "=".repeat(50));
        System.out.println("=== Polymorphism Demo ===");

        BankAccount[] accounts = new BankAccount[2];
        accounts[0] = savings;

        accounts[1] = fd;

        System.out.println("\nAll accounts (using parent reference):");
        for (BankAccount account : accounts) {
            System.out.println("\n--- Account " + account.getAccountNumber() + " ---");
            System.out.println(account);
            System.out.println(account.calculateInterest());
        }


    }
}
