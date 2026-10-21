package account;

public class BankAccount {
    private double balance;
    private boolean isFrozen;

    public BankAccount(double balance, boolean isFrozen) {
        this.balance = balance;
        this.isFrozen = isFrozen;
    }

        public BankAccount() {
        this.balance = 0;
        this.isFrozen = false;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isFrozen() {
        return isFrozen;
    }

    public void deposit(double amount) {
        if (isFrozen) {
            throw new IllegalStateException("Account is frozen. Cannot deposit.");
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (isFrozen) {
            throw new IllegalStateException("Account is frozen. Cannot withdraw.");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds.");
        }
        balance -= amount;
    }

    public void freezeAccount() {
        isFrozen = true;
    }

    public void unfreezeAccount() {
        isFrozen = false;
    }

    public void main(String[] args) {
        //Test Case 1
        BankAccount acc1 = new SavingsAccount("Leonel Messi");
        System.out.println("Account Owner: " + ((SavingsAccount) acc1).getOwnerName());

        //Test Case 2
        acc1.deposit(1000.125);
        System.out.println("Amount Deposited: " + acc1.getBalance() + "\nCurrent Balance: " + (float)(acc1.getBalance()));
    }
}
