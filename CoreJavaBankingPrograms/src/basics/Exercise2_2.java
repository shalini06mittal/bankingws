package basics;

import java.util.Scanner;

public class Exercise2_2 {
    public static void main(String[] args) {
        System.out.println("=== Investment Comparison Table ===");
        System.out.println("Principal amounts vs. Interest rates\n");

        double[] principals = {10000, 25000, 50000, 100000};
        double[] rates = {0.05, 0.07, 0.09, 0.11};
        int years = 5;

        // Print header
        System.out.print("Principal\t");
        for (double rate : rates) {
            System.out.printf("%.0f%%\t\t", rate * 100);
        }
        System.out.println();
        System.out.println("=".repeat(60));

        // Nested loop - outer loop for principals
        for (double principal : principals) {
            System.out.printf("$%.0f\t\t", principal);

            // Inner loop for rates
            for (double rate : rates) {
                double futureValue = principal * Math.pow(1 + rate, years);
                System.out.printf("$%.0f\t", futureValue);
            }
            System.out.println();
        }


    }

}



