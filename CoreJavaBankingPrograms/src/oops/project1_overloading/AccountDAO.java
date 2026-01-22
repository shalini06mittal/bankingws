package oops.project1_overloading;

public class AccountDAO {
    // Simulating database with array
    private BankAccount[] accounts;
    private int accountCount;
    private static final int MAX_ACCOUNTS = 100;

    public AccountDAO() {
        accounts = new BankAccount[MAX_ACCOUNTS];
        accountCount = 0;

        // Pre-populate with some data
        createAccount(new BankAccount(1001, "John Doe",  5000));
        createAccount(new BankAccount(1002, "Jane Smith",  3000));
        createAccount(new BankAccount(1003, "Bob Johnson", 10000));
    }

    // Create
    public boolean createAccount(BankAccount account) {
        if (accountCount < MAX_ACCOUNTS) {
            accounts[accountCount] = account;
            accountCount++;
            System.out.println("Account created successfully: " + account.getAccountNumber());
            return true;
        }
        System.out.println("Cannot create account. Database full.");
        return false;
    }

    // Read - find by account number
    public BankAccount findAccountByNumber(int accountNumber) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber() == accountNumber) {
                return accounts[i];
            }
        }
        return null; // Not found
    }

    // Read - get all accounts
    public BankAccount[] getAllAccounts() {

        return accounts;
    }

    // Update
    public boolean updateAccount(BankAccount account) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber() == account.getAccountNumber()) {
                accounts[i] = account;
                System.out.println("Account updated: " + account.getAccountNumber());
                return true;
            }
        }
        System.out.println("Account not found");
        return false;
    }

    // Delete
    public boolean deleteAccount(int accountNumber) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber() == accountNumber) {
                // Shift elements
                for (int j = i; j < accountCount - 1; j++) {
                    accounts[j] = accounts[j + 1];
                }
                accountCount--;
                accounts[accountCount].setActive(false);
                System.out.println("Account deactivated: " + accountNumber);
                return true;
            }
        }
        System.out.println("Account not found");
        return false;
    }


}
