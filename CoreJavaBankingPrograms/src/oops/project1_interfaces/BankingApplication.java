package oops.project1_interfaces;

import java.util.Scanner;
public class BankingApplication {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        AccountService accountService = new AccountService(new AccountDAOInMemory());
        System.out.println("=== Welcome to XYZ Bank ===");

        while (true) {
            System.out.println("\n=== Banking Menu ===");
            System.out.println("1. Open New Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Transfer Money");
            System.out.println("5. Check Balance");
            System.out.println("6. Display All Accounts");
            System.out.println("7. Generate Statement");
            System.out.println("8. Close Account");
            System.out.println("9. Exit");
            System.out.print("\nEnter choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter account number: ");
                    int accNo = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter initial deposit: $");
                    double deposit = scanner.nextDouble();

                    accountService.openAccount(accNo, name, deposit);
                    break;

                case 2:
                    System.out.print("Enter account number: ");
                    int depAccNo = scanner.nextInt();

                    System.out.print("Enter deposit amount: $");
                    double depAmount = scanner.nextDouble();

                    accountService.deposit(depAccNo, depAmount);
                    break;

                case 3:
                    System.out.print("Enter account number: ");
                    int withAccNo = scanner.nextInt();

                    System.out.print("Enter withdrawal amount: $");
                    double withAmount = scanner.nextDouble();

                    accountService.withdraw(withAccNo, withAmount);
                    break;

                case 4:
                    System.out.print("Enter source account number: ");
                    int fromAcc = scanner.nextInt();

                    System.out.print("Enter destination account number: ");
                    int toAcc = scanner.nextInt();

                    System.out.print("Enter transfer amount: $");
                    double transAmount = scanner.nextDouble();

                    accountService.transfer(fromAcc, toAcc, transAmount);
                    break;

                case 5:
                    System.out.print("Enter account number: ");
                    int balAccNo = scanner.nextInt();

                    accountService.checkBalance(balAccNo);
                    break;

                case 6:
                    accountService.displayAllAccounts();
                    break;

                case 7:
                    System.out.print("Enter account number: ");
                    int stmtAccNo = scanner.nextInt();

                    accountService.generateStatement(stmtAccNo);
                    break;

                case 8:
                    System.out.print("Enter account number to close: ");
                    int closeAccNo = scanner.nextInt();

                    accountService.closeAccount(closeAccNo);
                    break;

                case 9:
                    System.out.println("Thank you for banking with us!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

    }
}
