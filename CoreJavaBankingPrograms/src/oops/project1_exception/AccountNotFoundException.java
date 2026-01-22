package oops.project1_exception;

public class AccountNotFoundException extends Exception{

    public AccountNotFoundException(String message) {
        super(message);
    }

}
