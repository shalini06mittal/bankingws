package basics;

import java.util.Scanner;

public class Exercise1_1 {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Primitive data types
        int accountNumber = 1001;           // Whole numbers
        double accountBalance = 50000.50;   // Decimal numbers (money)
        boolean isActive = true;            // true/false
        char accountType = 'S';             // Single character (S=Savings, C=Current)
        // Reference type
        String customerName = "John Doe";   // Text
        // Display information
        System.out.println("=== Bank Account Information ===");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Account Type: " + accountType);
        System.out.println("Balance: $" + accountBalance);
        System.out.println("Active Status: " + isActive);
        System.out.print("\nEnter deposit amount: $");         // Taking user input
        double depositAmount = scanner.nextDouble();
        System.out.print("Enter withdrawal amount: $");
        double withdrawAmount = scanner.nextDouble();
        double newBalance = accountBalance + depositAmount - withdrawAmount;        // Simple calculation
        System.out.println("\n=== Updated Balance ===");
        System.out.println("Previous Balance: $" + accountBalance+" Deposited: $" + depositAmount);
        System.out.println("Withdrawn: $" + withdrawAmount);
        System.out.println("New Balance: $" + newBalance);
        scanner.close();

    }
}
