package oops.project1_interfaces;

public interface AccountDAO {
    // Simulating database with array

    // Create
    public boolean createAccount(BankAccount account) ;

    // Read - find by account number
    public BankAccount findAccountByNumber(int accountNumber) ;

    // Read - get all accounts
    public BankAccount[] getAllAccounts() ;

    // Update
    public boolean updateAccount(BankAccount account) ;

    // Delete
    public boolean deleteAccount(int accountNumber) ;


}
