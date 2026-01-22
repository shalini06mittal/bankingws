package basics;

import java.util.Scanner;

public class Exercise1_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter age: ");
        int age = scanner.nextInt();

        if(age>=18)
            System.out.println("Can Vote");
        else
            System.out.println("Cannot Vote");

        System.out.println("=== Loan EMI Calculator ===");
        System.out.print("Enter loan amount: ");
        double principal = scanner.nextDouble();
        System.out.print("Enter annual interest rate (%): ");
        double annualRate = scanner.nextDouble();
        System.out.print("Enter loan tenure (months): ");
        int months = scanner.nextInt();
        // Arithmetic operators
        double monthlyRate = annualRate / (12 * 100);
        double emi = (principal * monthlyRate * Math.pow(1 + monthlyRate, months))
                / (Math.pow(1 + monthlyRate, months) - 1);
        double totalPayment = emi * months;
        double totalInterest = totalPayment - principal;
        // Comparison operators
        boolean isAffordable = emi <= 5000;
        // Logical operators
        boolean isGoodLoan = (totalInterest < principal * 0.3) && (months <= 60);
        System.out.println("\n=== Loan Summary ===");
        System.out.printf("Monthly EMI: $%.2f%n", emi);
        System.out.printf("Total Payment: $%.2f%n", totalPayment);
        System.out.printf("Total Interest: $%.2f%n", totalInterest);
        System.out.println("Affordable (EMI <= $5000): " + isAffordable);
        System.out.println("Good Loan Terms: " + isGoodLoan);
        scanner.close();
    }

}

