package account;

import java.util.HashMap;
import java.util.Map;

/**
 * Manages multiple bank accounts using a Map and implements the Bank interface.
 */
public class BankAccountManager implements Bank {
    private static final int MAX_ACCOUNTS = 100;
    private Map<Integer, BankAccount> accounts;
    private int id;

    public BankAccountManager() {
        this.accounts = new HashMap<>();
        this.id = 0;
    }

    /** Adds an account to the accounts map with an id assigned to them starting at 0 */
    @Override
    public void addAccount(BankAccount account) {
        if (accounts.size() >= MAX_ACCOUNTS) {
            System.out.println
            ("Maximum account limit of 100 reached.Unable to add account.");
            return;
        }
        int assignedId = this.id++;
        accounts.put(assignedId, account);
        System.out.println
        ("Account added successfully with ID: " + assignedId);
    }

    @Override
    public BankAccount getAccount(int id) {
        return accounts.get(id);
    }

    /** Return the list of all accounts with their ID, name, and balance*/
    @Override
    public void listAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts available.");
            return;
        }
        for (Map.Entry<Integer, BankAccount> entry : accounts.entrySet()) {
            int accountId = entry.getKey();
            BankAccount account = entry.getValue();

            String ownerName = "Unknown";
            if (account instanceof SavingsAccount savingsAcc) {
                ownerName = savingsAcc.getOwnerName();
            }

            System.out.printf
            ("Account ID: %d, Account Name: %s, Balance: %.2f%n",
                    accountId, ownerName, account.getBalance());
        }
    }
}