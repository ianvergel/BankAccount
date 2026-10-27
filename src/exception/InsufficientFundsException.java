package exception;

/**
 * Thrown when a financial transaction is attempted on an account
 * that has lesser current balance than the withdrawal amount.
 */
public class InsufficientFundsException extends Exception {
    private String message;

    public InsufficientFundsException(String message) {
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override 
    public String getMessage() {
        return message;
    }
}
