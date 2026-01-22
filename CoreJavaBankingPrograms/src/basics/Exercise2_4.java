package basics;

import java.util.Scanner;

public class Exercise2_4 {
    public static void main(String[] args) {

        // 2D Array: [months][categories]
        String[] months = {"Jan", "Feb", "Mar"};
        String[] categories = {"Rent", "Food", "Transport", "Entertainment"};

        double[][] expenses = {
                {1200, 400, 150, 200},  // January
                {1200, 450, 140, 180},  // February
                {1200, 420, 160, 250}   // March
        };

        System.out.println("=== Quarterly Expense Report ===\n");

        // Print header
        System.out.print("Month\t\t");
        for (String category : categories) {
            System.out.print(category + "\t");
        }
        System.out.println("Total");
        System.out.println("=".repeat(70));

        // Print expenses
        double grandTotal = 0;

        for (int i = 0; i < months.length; i++) {
            System.out.print(months[i] + "\t\t");
            double monthTotal = 0;

            for (int j = 0; j < categories.length; j++) {
                System.out.print("$" + expenses[i][j] + "\t\t");
                monthTotal += expenses[i][j];
            }

            System.out.println("$" + monthTotal);
            grandTotal += monthTotal;
        }

        System.out.println("=".repeat(70));

        // Category totals
        System.out.print("Total\t");
        for (int j = 0; j < categories.length; j++) {
            double categoryTotal = 0;
            for (int i = 0; i < months.length; i++) {
                categoryTotal += expenses[i][j];
            }
            System.out.print("$" + categoryTotal + "\t\t");
        }
        System.out.println("$" + grandTotal);

        // Average per month
        System.out.printf("\nAverage monthly expense: $%.2f%n", grandTotal / months.length);


    }

}



