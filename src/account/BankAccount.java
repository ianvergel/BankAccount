package account;

/** Represents a bank account with a balance and transaction freeze state. */
public class BankAccount {
    private double balance;
    private boolean isFrozen;

    public BankAccount(double balance, boolean isFrozen) {
        this.balance = balance;
        this.isFrozen = isFrozen;
    }

    public BankAccount() {
        this.balance = 0.0;
        this.isFrozen = false;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isFrozen() {
        return isFrozen;
    }

    public void freezeAccount() {
        this.isFrozen = true;
    }

    public void unfreezeAccount() {
        this.isFrozen = false;
    }

    /** Deposits a positive amount unless the account is frozen. */
    public void deposit(double amount) {
        if (isFrozen) {
            System.out.println("Account is FROZEN. Unable to transact.");
            return;
        }

        if (amount <= 0) {
            System.out.println("Amount deposited: " + amount);
            System.out.println("Invalid amount. Must be greater than 0");
            return;
        }

        balance += amount;
        System.out.printf("Amount deposited: %.2f%n", amount);
        System.out.printf("Current balance: %.2f%n", balance);
    }

    /**
     * Withdraws a positive amount unless the account is frozen and has sufficient
     * balance.
     */
    public void withdraw(double amount) {
        if (isFrozen) {
            System.out.println("Account is FROZEN. Unable to transact.");
            return;
        }

        System.out.println("Amount withdrawn: " + amount);

        if (amount <= 0) {
            System.out.println("Invalid amount. Must be greater than 0");
            return;
        }

        if (amount > balance) {
            System.out.println("Insufficient balance.");
            System.out.printf("Current balance: %.2f%n", balance);
            return;
        }

        balance -= amount;
        System.out.printf("Current balance: %.2f%n", balance);
    }

    /** Runs the bank account test cases. */
    public void main(String[] args) {
        BankAccount acc1 = new SavingsAccount("Test0");

        // Test Case 1
        System.out.println("Test Case 1:");
        if (acc1 instanceof SavingsAccount savingsAcc) {
            System.out.println("Account Owner: " + savingsAcc.getOwnerName() + ".");
        }

        // Test Case 2
        System.out.println("\nTest Case 2:");
        acc1.deposit(1000.125);

        // Test Case 3
        System.out.println("\nTest Case 3:");
        acc1.deposit(0);

        // Test Case 4
        System.out.println("\nTest Case 4:");
        acc1.deposit(-500);

        // Test Case 5
        System.out.println("\nTest Case 5:");
        acc1.withdraw(500);

        // Test Case 6
        System.out.println("\nTest Case 6:");
        acc1.withdraw(1500);

        // Test Case 7
        System.out.println("\nTest Case 7:");
        acc1.withdraw(-100);

        // Test Case 8
        System.out.println("\nTest Case 8:");
        acc1.freezeAccount();
        acc1.deposit(11500);

        // Test Case 9
        System.out.println("\nTest Case 9:");
        acc1.withdraw(500);

        // Test Case 10
        System.out.println("\nTest Case 10:");
        acc1.unfreezeAccount();
        acc1.withdraw(100);
    }
}
