package basics;

import java.util.Scanner;

public class Exercise2_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double salary, increment;

        System.out.println("Enter starting salary: ");
        salary = scanner.nextDouble();

        System.out.println("Enter annual increment percentage: ");
        increment = scanner.nextDouble();

        for (int year = 1; year <= 5; year++) {
            salary = salary + (salary * increment / 100);
            System.out.printf("Salary after year %d = %.2f\n", year, salary);
        }

        System.out.println("=== Investment Growth Projection ===");
        System.out.print("Enter initial investment: $");
        double principal = scanner.nextDouble();

        System.out.print("Enter annual return rate (%): ");
        double rate = scanner.nextDouble() / 100;

        System.out.print("Enter investment period (years): ");
        int years = scanner.nextInt();

        // For loop - when you know the number of iterations
        System.out.println("\n=== Year-by-Year Growth ===");
        double currentValue = principal;

        for (int year = 1; year <= years; year++) {
            // currentValue = currentValue + (currentValue * rate);
            currentValue = currentValue * (1 + rate);
            System.out.printf("Year %d: $%.2f%n", year, currentValue);
        }

        System.out.printf("\nTotal Growth: $%.2f%n", currentValue - principal);

        // While loop example - transaction processing
        System.out.println("\n=== Process Daily Transactions ===");
        System.out.println("Enter transaction amounts (0 to finish):");

        double totalDeposits = 0;
        int transactionCount = 0;

        while (true) {
            System.out.print("Transaction " + (transactionCount + 1) + ": $");
            double amount = scanner.nextDouble();

            if (amount == 0) {
                break; // Exit loop
            }

            totalDeposits += amount;
            transactionCount++;
        }

        System.out.println("\n=== Transaction Summary ===");
        System.out.println("Total Transactions: " + transactionCount);
        System.out.printf("Total Deposited: $%.2f%n", totalDeposits);

        if (transactionCount > 0) {
            System.out.printf("Average Transaction: $%.2f%n", totalDeposits / transactionCount);
        }

        // Do-while loop - ATM PIN verification
        System.out.println("\n=== ATM PIN Verification ===");
        int correctPIN = 1234;
        int attempts = 0;
        int maxAttempts = 3;
        boolean authenticated = false;

        do {
            System.out.print("Enter PIN: ");
            int enteredPIN = scanner.nextInt();
            attempts++;

            if (enteredPIN == correctPIN) {
                authenticated = true;
                System.out.println(" Authentication successful!");
                break;
            } else {
                System.out.println("Incorrect PIN. Attempts remaining: " + (maxAttempts - attempts));
            }

        } while (attempts < maxAttempts);

        if (!authenticated) {
            System.out.println("🔒 Account locked. Contact your bank.");
        }

        scanner.close();

    }

}



