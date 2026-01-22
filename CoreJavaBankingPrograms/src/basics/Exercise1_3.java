package basics;

import java.util.Scanner;

public class Exercise1_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Credit Card Approval System ===");
        System.out.print("Enter your annual income: $");
        double income = scanner.nextDouble();

        System.out.print("Enter your credit score (300-850): ");
        int creditScore = scanner.nextInt();

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        System.out.print("Do you have existing loans? (true/false): ");
        boolean hasLoans = scanner.nextBoolean();

        // If-else decision making
        String cardType = "";
        double creditLimit = 0;

        if (age < 18) {
            System.out.println("\n Application DENIED: Must be 18 or older");
        } else if (creditScore < 600) {
            System.out.println("\n Application DENIED: Credit score too low");
        } else if (income < 20000) {
            System.out.println("\n Application DENIED: Minimum income not met");
        } else if (creditScore >= 750 && income >= 80000) {
            cardType = "PLATINUM";
            creditLimit = income * 3;
            System.out.println("\n Congratulations! Approved for " + cardType);
        } else if (creditScore >= 700 && income >= 50000) {
            cardType = "GOLD";
            creditLimit = income * 2;
            System.out.println("\n Congratulations! Approved for " + cardType);
        } else {
            cardType = "SILVER";
            creditLimit = income * 1;
            System.out.println("\n Approved for " + cardType);
        }

        // Additional checks
        if (!cardType.isEmpty()) {
            if (hasLoans) {
                creditLimit *= 0.7; // Reduce limit by 30% if has loans
                System.out.println("⚠️  Credit limit reduced due to existing loans");
            }

            System.out.printf("Credit Limit: $%.2f%n", creditLimit);
        }

        scanner.close();
    }

}



