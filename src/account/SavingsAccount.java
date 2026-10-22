package account;

/** Represents a savings account with an owner name. */
public class SavingsAccount extends BankAccount {
    private String ownerName;

    public SavingsAccount(String ownerName) {
        super(0, false);
        this.ownerName = ownerName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}
