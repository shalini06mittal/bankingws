package oops.basic;

public class TestBankAccount {
    public static void main(String[] args) {

        BankAccount account1 = new BankAccount();

        account1.accountNumber = 1001;
        account1.accountHolderName = "John Doe";
        account1.balance = 5000.0;
        account1.isActive = true;

        account1.displayAccountInfo();

        double bal = account1.deposit(2000);
        System.out.println("balance after deposit "+bal);


        System.out.println("balance after withdraw "+ account1.withdraw(1500));
    }
}
