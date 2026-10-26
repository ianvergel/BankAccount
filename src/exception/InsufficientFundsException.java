package exception;

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
