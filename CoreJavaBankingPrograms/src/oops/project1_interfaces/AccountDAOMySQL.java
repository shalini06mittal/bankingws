package oops.project1_interfaces;

public class AccountDAOMySQL implements AccountDAO{
    // Simulating database with array

    public AccountDAOMySQL() {

    }

    // Create
    public boolean createAccount(BankAccount account) {
            System.out.println("Account created successfully: in database : INSERT " + account.getAccountNumber());
            return true;

    }

    // Read - find by account number
    public BankAccount findAccountByNumber(int accountNumber) {
        System.out.println("Find Acc By Number - SELECT database");
        return null; // Not found
    }

    // Read - get all accounts
    public BankAccount[] getAllAccounts() {
        System.out.println(" SELECT ALL ACCOUNTS database");
        return null;
    }

    // Update
    public boolean updateAccount(BankAccount account) {

        System.out.println("UPDATE Account database");
        return false;
    }

    // Delete
    public boolean deleteAccount(int accountNumber) {

        System.out.println("DELETE Account database");
        return false;
    }


}
