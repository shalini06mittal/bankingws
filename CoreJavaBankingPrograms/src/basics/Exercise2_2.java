package basics;

import java.util.Scanner;

public class Exercise2_2 {
    public static void main(String[] args) {
        System.out.println("=== Investment Comparison Table ===");
        System.out.println("Principal amounts vs. Interest rates\n");

        int years = 5;

        // Print header
        System.out.print("Principal\t");
        for (int rate = 5; rate <= 11; rate+=2) {
            System.out.printf("%d%%\t\t", rate);
        }
        System.out.println();
        System.out.println("=".repeat(60));

        // Nested loop - outer loop for principals
        for (double principal=10000; principal<=100000; principal+=25000) {
            System.out.printf("$%.0f\t\t", principal);

            // Inner loop for rates
            for (int rate = 5; rate <= 11; rate+=2) {
                double futureValue = principal * Math.pow(1 + rate/100.0, years);
                System.out.printf("$%.0f\t", futureValue);
            }
            System.out.println();
        }


    }

}



