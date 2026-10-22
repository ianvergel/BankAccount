package account;

import java.time.LocalDateTime;
import java.util.*;

/** Represents a bank account with a balance and transaction freeze state. */
public class BankAccount {
    private double balance;
    private boolean isFrozen;
    private List<Transaction> transactionHistory;

    public BankAccount(double balance, boolean isFrozen) {
        this.balance = balance;
        this.isFrozen = isFrozen;
        this.transactionHistory = new ArrayList<>();
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
        transactionHistory.add(new Transaction("Deposit", amount));
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
        transactionHistory.add(new Transaction("Withdraw", amount));
        System.out.printf("Current balance: %.2f%n", balance);
    }

    public List<Transaction> getTransactionHistory(String type, double amount, LocalDateTime time_stamp) {
        return transactionHistory;
    }

    /** Runs the bank account test cases.  */
    public void main(String[] args) {
        
    }
}
