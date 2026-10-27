package account;

import java.util.ArrayList;
import java.util.List;
import exception.AccountFrozenException;
import exception.InvalidAmountException;
import exception.InsufficientFundsException;

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
    public void deposit(double amount)
    throws AccountFrozenException,InvalidAmountException {
        if (isFrozen()) {
            throw new AccountFrozenException
            ("Account is FROZEN. Unable to transact.\n");
        }

        if (amount <= 0) {
            System.out.printf("Amount deposited: %.2f%n", amount);
            throw new InvalidAmountException(
                    "Invalid amount. Must be greater than 0.\n");
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
    public void withdraw(double amount)
            throws AccountFrozenException, 
            InvalidAmountException, 
            InsufficientFundsException {
        if (isFrozen()) {
            throw new AccountFrozenException
            ("Account is FROZEN. Unable to transact.\n");
        }

        if (amount <= 0) {
            System.out.printf("Amount Withdrawn: %.2f%n", amount);
            throw new InvalidAmountException
            ("Invalid amount. Must be greater than 0.\n");
        }

        if (amount > balance) {
            System.out.printf("Amount Withdrawn: %.2f%n", amount);
            throw new InsufficientFundsException("Insufficient balance.");
        }

        balance -= amount;
        transactionHistory.add(new Transaction("Withdraw", amount));
        System.out.printf("Amount withdrawn: %.2f%n", amount);
        System.out.printf("Current balance: %.2f%n", balance);
    }

    /** Returns the transaction history list. */
    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }
}