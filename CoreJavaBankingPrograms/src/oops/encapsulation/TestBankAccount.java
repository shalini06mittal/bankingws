package oops.encapsulation;

public class TestBankAccount {
    public static void main(String[] args) {

        BankAccount account1 = new BankAccount();

        account1.setAccountNumber(101);
        account1.setAccountHolderName("Peterson");
        account1.setBalance(2000);

        System.out.println(account1);

    }
}
