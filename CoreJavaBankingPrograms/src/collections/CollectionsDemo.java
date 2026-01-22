package collections;

import java.util.*;

public class CollectionsDemo {
    public static void main(String[] args) {

        // 1. ArrayList - Dynamic array, maintains insertion order
        System.out.println("=== ArrayList Demo ===");
        ArrayList<Transaction> transactions = new ArrayList<>();

        transactions.add(new Transaction("TXN001", 1001, "DEPOSIT", 5000, "Initial deposit"));
        transactions.add(new Transaction("TXN002", 1001, "WITHDRAWAL", 1000, "ATM withdrawal"));
        transactions.add(new Transaction("TXN003", 1001, "DEPOSIT", 2000, "Salary credit"));
        transactions.add(new Transaction("TXN004", 1002, "TRANSFER", 500, "To savings"));

        System.out.println("Total transactions: " + transactions.size());
        System.out.println("\nAll transactions:");
        for (Transaction t : transactions) {
            System.out.println(t);
        }

        // Accessing by index
        System.out.println("\nFirst transaction: " + transactions.get(0));

        // Removing
        transactions.remove(1);  // Remove by index
        System.out.println("\nAfter removing index 1: " + transactions.size() + " transactions");

        // 2. LinkedList - Better for frequent insertions/deletions
        System.out.println("\n" + "=".repeat(60));
        System.out.println("=== LinkedList Demo (Transaction Queue) ===");
        LinkedList<Transaction> transactionQueue = new LinkedList<>();

        transactionQueue.add(new Transaction("TXN005", 1003, "DEPOSIT", 1000, "Check deposit"));
        transactionQueue.add(new Transaction("TXN006", 1004, "WITHDRAWAL", 500, "Cash withdrawal"));
        transactionQueue.add(new Transaction("TXN007", 1003, "TRANSFER", 300, "Bill payment"));

        System.out.println("Processing transactions in queue:");
        while (!transactionQueue.isEmpty()) {
            Transaction t = transactionQueue.removeFirst();  // Queue behavior (FIFO)
            System.out.println("Processing: " + t);
        }

        // 3. HashSet - No duplicates, no order
        System.out.println("\n" + "=".repeat(60));
        System.out.println("=== HashSet Demo (Unique Account Numbers) ===");
        HashSet<Integer> activeAccounts = new HashSet<>();

        activeAccounts.add(1001);
        activeAccounts.add(1002);
        activeAccounts.add(1003);
        activeAccounts.add(1001);  // Duplicate - will be ignored
        activeAccounts.add(1004);

        System.out.println("Unique active accounts: " + activeAccounts.size());
        System.out.println("Account numbers: " + activeAccounts);

        // Check membership
        if (activeAccounts.contains(1002)) {
            System.out.println("Account 1002 is active");
        }

        // 4. HashMap - Key-Value pairs
        System.out.println("\n" + "=".repeat(60));
        System.out.println("=== HashMap Demo (Account Balances) ===");
        HashMap<Integer, Double> accountBalances = new HashMap<>();

        accountBalances.put(1001, 5000.0);
        accountBalances.put(1002, 3000.0);
        accountBalances.put(1003, 10000.0);
        accountBalances.put(1004, 7500.0);

        // Retrieve
        System.out.println("Account 1002 balance: $" + accountBalances.get(1002));

        // Update
        accountBalances.put(1002, 3500.0);  // Updates existing value
        System.out.println("Updated Account 1002 balance: $" + accountBalances.get(1002));

        // Iterate through map
        System.out.println("\nAll account balances:");
        for (Map.Entry<Integer, Double> entry : accountBalances.entrySet()) {
            System.out.printf("Account %d: $%.2f%n", entry.getKey(), entry.getValue());
        }

        // 5. TreeSet - Sorted set
        System.out.println("\n" + "=".repeat(60));
        System.out.println("=== TreeSet Demo (Sorted Transaction Amounts) ===");
        TreeSet<Double> transactionAmounts = new TreeSet<>();

        transactionAmounts.add(5000.0);
        transactionAmounts.add(1500.0);
        transactionAmounts.add(3000.0);
        transactionAmounts.add(500.0);
        transactionAmounts.add(10000.0);

        System.out.println("Amounts in sorted order: " + transactionAmounts);
        System.out.println("Lowest amount: $" + transactionAmounts.first());
        System.out.println("Highest amount: $" + transactionAmounts.last());

        // 6. TreeMap - Sorted map
        System.out.println("\n" + "=".repeat(60));
        System.out.println("=== TreeMap Demo (Sorted Accounts) ===");
        TreeMap<Integer, String> accountHolders = new TreeMap<>();

        accountHolders.put(1003, "Charlie");
        accountHolders.put(1001, "Alice");
        accountHolders.put(1004, "David");
        accountHolders.put(1002, "Bob");

        System.out.println("Accounts in sorted order:");
        for (Map.Entry<Integer, String> entry : accountHolders.entrySet()) {
            System.out.println("Account " + entry.getKey() + ": " + entry.getValue());
        }

        // 7. ArrayList of custom objects with sorting
        System.out.println("\n" + "=".repeat(60));
        System.out.println("=== Sorting Transactions ===");

        ArrayList<Transaction> allTransactions = new ArrayList<>();
        allTransactions.add(new Transaction("TXN008", 1001, "DEPOSIT", 3000, "Desc1"));
        allTransactions.add(new Transaction("TXN009", 1002, "WITHDRAWAL", 500, "Desc2"));
        allTransactions.add(new Transaction("TXN010", 1001, "TRANSFER", 1500, "Desc3"));
        allTransactions.add(new Transaction("TXN011", 1003, "DEPOSIT", 7000, "Desc4"));

        // Sort by amount using Comparator
        Collections.sort(allTransactions, new Comparator<Transaction>() {
            @Override
            public int compare(Transaction t1, Transaction t2) {
                return Double.compare(t2.getAmount(), t1.getAmount());  // Descending
            }
        });

        System.out.println("Transactions sorted by amount (descending):");
        for (Transaction t : allTransactions) {
            System.out.println(t);
        }
    }

}
