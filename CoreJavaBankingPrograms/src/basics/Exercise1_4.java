package basics;

import java.util.Scanner;

public class Exercise1_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Transaction Fee Calculator ===");
        System.out.println("Transaction Types:");
        System.out.println("D - Domestic Transfer");
        System.out.println("I - International Transfer");
        System.out.println("B - Bill Payment");
        System.out.println("A - ATM Withdrawal");
        System.out.print("\nEnter transaction type: ");
        char type = scanner.next().toUpperCase().charAt(0);

        System.out.print("Enter transaction amount: $");
        double amount = scanner.nextDouble();

        double fee = 0;
        String description = "";

        switch(type) {
            case 'D':
                fee = amount * 0.001; // 0.1%
                description = "Domestic Transfer";
                break;
            case 'I':
                fee = amount * 0.03 + 25; // 3% + $25 fixed
                description = "International Transfer";
                break;
            case 'B':
                fee = 1.50; // Fixed fee
                description = "Bill Payment";
                break;
            case 'A':
                fee = 2.00; // Fixed ATM fee
                description = "ATM Withdrawal";
                break;
            default:
                System.out.println("Invalid transaction type!");
                scanner.close();
                return;
        }

        System.out.println("\n=== Transaction Summary ===");
        System.out.println("Type: " + description);
        System.out.printf("Amount: $%.2f%n", amount);
        System.out.printf("Fee: $%.2f%n", fee);
        System.out.printf("Total: $%.2f%n", amount + fee);

        scanner.close();

    }

}



