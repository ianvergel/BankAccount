import java.util.List;

import account.BankAccount;
import account.SavingsAccount;
import account.Transaction;
import account.BankAccountManager;

public class App {

    /**
    *Functional interface to allow lambdas that throw checked exceptions.
    */
    @FunctionalInterface
    interface CheckedTransaction {
        void execute() throws Exception;
    }

    /**
    * Helper function to remove redundant inline exception handling
    * (individual try catch on each call) on each test cases in Activity 1,
    * can also be implemented on test cases in Activity 3 however we prioritize
    * showing explicit inline handling for Activity 3.
    */
    private static void tryTransaction(CheckedTransaction action) {
        try {
            action.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws Exception {
        BankAccount acc1 = new SavingsAccount("Test0");
        BankAccountManager manager = new BankAccountManager();

        System.out.println("============Activity 1 Test Cases============");
        if (acc1 instanceof SavingsAccount savingsAcc) {
            System.out.println("Account Owner: " + savingsAcc.getOwnerName() + ".");
        }

        tryTransaction(() -> acc1.deposit(1000.125));
        tryTransaction(() -> acc1.deposit(0));
        tryTransaction(() -> acc1.deposit(-500));
        tryTransaction(() -> acc1.withdraw(500));
        tryTransaction(() -> acc1.withdraw(1500));
        tryTransaction(() -> acc1.withdraw(-100));

        acc1.freezeAccount();
        tryTransaction(() -> acc1.deposit(11500));
        tryTransaction(() -> acc1.withdraw(500));
        acc1.unfreezeAccount();

        tryTransaction(() -> acc1.withdraw(100));
        
        /**
        * To clear the list so that the transactions from Activity 1
        * do not spill over and display inside Activity 3's test cases.
        */
        acc1.getTransactionHistory().clear();

        System.out.println("\n============Activity 2 Test Cases============");
        // 2.1
        for (Transaction transaction : acc1.getTransactionHistory()) {
            System.out.println(transaction);
        }

        // 2.2
        BankAccountManager accM1 = new BankAccountManager();
        System.out.println("BankAccountManager created successfully.");

        // 2.3
        accM1.addAccount(acc1);

        // 2.4
        accM1.addAccount(new SavingsAccount("Test1"));

        // 2.5
        accM1.listAccounts();

        System.out.println("\n===========Activity 3 Test Cases============\n");
        // 3.1
        try {
            acc1.deposit(-500);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // 3.2
        acc1.freezeAccount();
        try {
            acc1.deposit(11500);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        acc1.unfreezeAccount();

        // 3.3
        try {
            acc1.withdraw(-100);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // 3.4
        try {
            acc1.withdraw(1500);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.printf("Current balance: %.2f%n\n", acc1.getBalance());
        }

        // 3.5
        acc1.freezeAccount();
        try {
            acc1.withdraw(500);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        acc1.unfreezeAccount();

        // 3.6
        // Populate test dataset for filtering (Test 3.6) and sorting (Test 3.7)
        acc1.deposit(1000.125);
        acc1.withdraw(500.0);
        acc1.withdraw(100.0);

        System.out.println("\nFiltering transactions at or above 200...");
        List<Transaction> filtered = manager.filterTransactionsAtOrAbove(200, acc1.getTransactionHistory());
        for (Transaction transaction : filtered) {
            System.out.println(transaction);
        }

        // 3.7
        System.out.println("\nSorting transactions by amount...");
        List<Transaction> sorted = manager.sortTransactionsByAmount(acc1.getTransactionHistory());
        for (Transaction transaction : sorted) {
            System.out.println(transaction);
        }
    }
}