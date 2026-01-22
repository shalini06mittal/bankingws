package oops.constructor;

public class TestBankAccount {
    public static void main(String[] args) {

        BankAccount account1 = new BankAccount();

        BankAccount account2 = new BankAccount(1001, "Jiya Sharma", 5000.0);

        account2.displayAccountInfo();

        double bal = account2.deposit(2000);
        System.out.println("balance after deposit "+bal);

        System.out.println("balance after withdraw "+ account2.withdraw(1500));

    }
}
