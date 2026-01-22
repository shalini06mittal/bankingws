package basics;

import java.util.Scanner;

public class Exercise2_3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Array declaration and initialization
        String[] stockNames = {"AAPL", "GOOGL", "MSFT", "AMZN", "TSLA"};
        double[] stockPrices = {150.50, 2800.75, 310.20, 3200.00, 245.80};
        int[] shares = {10, 5, 15, 3, 20};

        System.out.println("=== Stock Portfolio ===");
        System.out.println("Stock\t\tPrice\t\tShares\t\tValue");
        System.out.println("=".repeat(50));

        double totalPortfolioValue = 0;

        // Loop through arrays
        for (int i = 0; i < stockNames.length; i++) {
            double stockValue = stockPrices[i] * shares[i];
            totalPortfolioValue += stockValue;
            /**
             * %-10s   → left-aligned String, width 10
             * $%-11.2f → currency with 2 decimals, width 11
             * %-10d   → integer, width 10
             * %n      → new line
             */
            System.out.printf("%-10s $%-11.2f %-10d $%-11.2f%n",
                    stockNames[i], stockPrices[i], shares[i], stockValue);
        }

        System.out.println("=".repeat(50));
        System.out.printf("Total Portfolio Value: $%.2f%n", totalPortfolioValue);

        // Find highest valued stock
        double maxValue = 0;
        String maxStock = "";

        for (int i = 0; i < stockNames.length; i++) {
            double value = stockPrices[i] * shares[i];
            if (value > maxValue) {
                maxValue = value;
                maxStock = stockNames[i];
            }
        }

        System.out.println("Highest valued holding: " + maxStock + " ($" + maxValue + ")");

        // Enhanced for loop (for-each)
        System.out.println("\n=== All Stock Symbols ===");
        for (String stock : stockNames) {
            System.out.println("- " + stock);
        }

        // User input into array
        System.out.print("\nEnter number of transactions to record: ");
        int count = scanner.nextInt();

        double[] transactions = new double[count];

        for (int i = 0; i < count; i++) {
            System.out.print("Transaction " + (i + 1) + ": $");
            transactions[i] = scanner.nextDouble();
        }

        System.out.println("\n=== Transaction History ===");
        double total = 0;
        for (int i = 0; i < transactions.length; i++) {
            System.out.printf("%d. $%.2f%n", (i + 1), transactions[i]);
            total += transactions[i];
        }
        System.out.printf("Total: $%.2f%n", total);

        scanner.close();


    }

}



