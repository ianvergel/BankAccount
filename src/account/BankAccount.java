package account;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a bank account with a balance, freeze state, and transaction
 * history.
 */
public class BankAccount {
    private double balance;
    private boolean isFrozen;
    private List<Transaction> transactionHistory;

    public BankAccount() {
        this.balance = 0.0;
        this.isFrozen = false;
        this.transactionHistory = new ArrayList<>();
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

    /**
    * Deposits a positive amount that is, only if the account is not Frozen
    * and the amount is not lesser than or equal to 0.
    */
    public void deposit(double amount) {
        if (isFrozen()) {
            System.out.println("Account is FROZEN. Unable to transact.");
            return;
        }

        if (amount <= 0) {
            System.out.printf("Amount deposited: %.2f%n", amount);
            System.out.println("Invalid amount. Must be greater than 0");
            return;
        }

        balance += amount;
        transactionHistory.add(new Transaction("Deposit", amount));
        System.out.printf("Amount deposited: %.2f%n", amount);
        System.out.printf("Current balance: %.2f%n", balance);
    }
    /**
    * Withdraws a positive amount that is, only if the account is not Frozen
    * and the balance is not lesser than the amount withdrawn.
    */
    public void withdraw(double amount) {
        if (isFrozen()) {
            System.out.println("Account is FROZEN. Unable to transact.");
            return;
        }

        System.out.printf("Amount withdrawn: %.2f%n", amount);

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
        transactionHistory.add(new Transaction("Withdraw", amount));
        System.out.printf("Current balance: %.2f%n", balance);
    }

    /** Returns the transaction history list. */
    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }
}