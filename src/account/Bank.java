package account;

/** Represents a bank with account id,
 * including adding new accounts, and all list of accounts
 */
public interface Bank {
    void addAccount(BankAccount account);
    BankAccount getAccount(int id);
    void listAccounts();
}
