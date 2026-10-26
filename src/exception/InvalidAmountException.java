package exception;

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
