package oops.project1_interfaces;

public class AccountService {
    private AccountDAO accountDAO;

    public AccountService(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    // Business method: Deposit money
    public boolean deposit(int accountNumber, double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive");
            return false;
        }

        BankAccount account = accountDAO.findAccountByNumber(accountNumber);

        if (account == null) {
            System.out.println("Account not found");
            return false;
        }

        if (!account.isActive()) {
            System.out.println("Account is inactive");
            return false;
        }

//        double newBalance = account.getBalance() + amount;
//        account.setBalance(newBalance);
        accountDAO.updateAccount(account);

        account.credit(amount);
        System.out.printf("Deposited $%.2f. New balance: $%.2f%n", amount, account.getBalance());
        return true;
    }

    // Business method: Withdraw money
    public boolean withdraw(int accountNumber, double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive");
            return false;
        }

        BankAccount account = accountDAO.findAccountByNumber(accountNumber);

        if (account == null) {
            System.out.println("Account not found");
            return false;
        }

        if (!account.isActive()) {
            System.out.println("Account is inactive");
            return false;
        }

        if (account.getBalance() < amount) {
            System.out.println("Insufficient balance");
            return false;
        }

        account.debit(amount);
        accountDAO.updateAccount(account);

        System.out.printf("Withdrawn $%.2f. Remaining balance: $%.2f%n", amount, account.getBalance());
        return true;
    }
    // Business method: Open new account
    public boolean openAccount(int accountNumber, String name, double initialDeposit) {
        // Business validation
        if (initialDeposit < 500) {
            System.out.println("Minimum initial deposit is $500");
            return false;
        }

        // Check if account already exists
        if (accountDAO.findAccountByNumber(accountNumber) != null) {
            System.out.println("Account number already exists");
            return false;
        }

        BankAccount newAccount = new BankAccount(accountNumber, name, initialDeposit);
        return accountDAO.createAccount(newAccount);
    }



    // Business method: Transfer money
    public boolean transfer(int fromAccount, int toAccount, double amount) {
        if (fromAccount == toAccount) {
            System.out.println("Cannot transfer to same account");
            return false;
        }

        BankAccount source = accountDAO.findAccountByNumber(fromAccount);
        BankAccount destination = accountDAO.findAccountByNumber(toAccount);

        if (source == null || destination == null) {
            System.out.println("One or both accounts not found");
            return false;
        }

        if (withdraw(fromAccount, amount)) {
            deposit(toAccount, amount);
            System.out.println("Transfer completed successfully");
            return true;
        }

        return false;
    }

    // Business method: Check balance
    public void checkBalance(int accountNumber) {
        BankAccount account = accountDAO.findAccountByNumber(accountNumber);

        if (account == null) {
            System.out.println("Account not found");
            return;
        }

        System.out.printf("Account %d - %s: $%.2f%n",
                accountNumber, account.getAccountHolderName(), account.getBalance());
    }

    // Business method: Display all accounts
    public void displayAllAccounts() {
        BankAccount[] allAccounts = accountDAO.getAllAccounts();

        System.out.println("\n=== All Bank Accounts ===");
        System.out.println("Acc No\tName\t\tBalance\t\tStatus");
        System.out.println("=".repeat(80));

        for (BankAccount account : allAccounts) {

            if(account == null) break;

            System.out.printf("%d\t%-20s\t$%.2f\t\t%s%n",
                    account.getAccountNumber(),
                    account.getAccountHolderName(),
                    account.getBalance(),
                    account.isActive() ? "Active" : "Inactive");
        }
    }

    // Business method: Generate account statement
    public void generateStatement(int accountNumber) {
        BankAccount account = accountDAO.findAccountByNumber(accountNumber);

        if (account == null) {
            System.out.println("Account not found");
            return;
        }

        System.out.println("\n" + "=".repeat(50));
        System.out.println("          ACCOUNT STATEMENT");
        System.out.println("=".repeat(50));
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Account Holder: " + account.getAccountHolderName());
        System.out.println("Current Balance: $" + account.getBalance());
        System.out.println("Status: " + (account.isActive() ? "Active" : "Inactive"));
        System.out.println("=".repeat(50));
    }

    // Business method: Close account
    public boolean closeAccount(int accountNumber) {
        BankAccount account = accountDAO.findAccountByNumber(accountNumber);

        if (account == null) {
            System.out.println("Account not found");
            return false;
        }

        if (account.getBalance() > 0) {
            System.out.println("Cannot close account with positive balance. Please withdraw all funds first.");
            return false;
        }

        return accountDAO.deleteAccount(accountNumber);
    }

}
