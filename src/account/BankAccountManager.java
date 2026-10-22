package account;

import java.util.Map;
import java.util.HashMap;

public class BankAccountManager implements Bank {
    private static final int MAX_ACCOUNTS = 100;
    private Map<Integer, BankAccount> accounts;
    private int id;

    public BankAccountManager() {
        this.accounts = new HashMap<>();
        this.id = 0;
    }

    @Override 
    public void addAccount(BankAccount account) {
        if (accounts.size() >= MAX_ACCOUNTS) {
            System.out.println("Maximum account limit of 100 reached. Unable to add account.");
            return;
        }
        this.id = id++;
        accounts.put(id, account);
    }

    @Override
    public BankAccount getAccount(int id) {
        BankAccount account = accounts.get(id);
        if (account != null) {
            System.out.println("Account found with ID: " + id);
        } else {
            System.out.println("Account not found.");
        }
        return account;
    }

    @Override 
    public void listAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts available.");
            return;
        }
        System.out.println("List of accounts:");
        for (Map.Entry<Integer, BankAccount> entry : accounts.entrySet()) {
            int accountId = entry.getKey();
            BankAccount account = entry.getValue();
            
            String ownerInfo = "";
            if (account instanceof SavingsAccount savingsAcc) {
                ownerInfo = ", Owner: " + savingsAcc.getOwnerName();
            }

            System.out.printf("ID: %d%s, Balance: %.2f, Frozen: %b%n", 
                accountId, ownerInfo, account.getBalance(), account.isFrozen());
        }
    }
}
