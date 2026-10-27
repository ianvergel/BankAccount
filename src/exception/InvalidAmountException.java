package exception;

/**
 * Thrown when a financial transaction is attempting a deposit
 * or withdrawal with an amount lesser or equal to zero.
 */
public class InvalidAmountException extends Exception {
    private String message;

    public InvalidAmountException(String message) {
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
