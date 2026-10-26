import account.BankAccount;
import account.SavingsAccount;
import account.Transaction;
import account.BankAccountManager;

public class App {
    public static void main(String[] args) throws Exception {
        BankAccount acc1 = new SavingsAccount("Test0");

        System.out.println("Activity 1 Test Cases");
        if (acc1 instanceof SavingsAccount savingsAcc) {
            System.out.println
            ("Account Owner: " + savingsAcc.getOwnerName() + ".");
        }

        // acc1.deposit(1000.125);
        // acc1.deposit(0);
        // acc1.deposit(-500);
        // acc1.withdraw(500);
        // acc1.withdraw(1500);
        // acc1.withdraw(-100);
        // acc1.freezeAccount();
        // acc1.deposit(11500);
        // acc1.withdraw(500);
        // acc1.unfreezeAccount();
        // acc1.withdraw(100);

        System.out.println("\nActivity 2 Test Cases");
        //2.1
        for (Transaction transaction : acc1.getTransactionHistory()) {
        System.out.println(transaction);
        }

        //2.2
        BankAccountManager accM1 = new BankAccountManager();
        System.out.println("BankAccountManager created successfully.");

        //2.3
        accM1.addAccount(acc1);

        //2.4
        accM1.addAccount(new SavingsAccount("Test1"));

        //2.5
        accM1.listAccounts();


        System.out.println("\nActivity 3 Test Cases");
        //3.1
        try {
            acc1.deposit(-500);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        

        //3.2
        acc1.freezeAccount();
        try {
            acc1.deposit(11500);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        acc1.unfreezeAccount();
        

        //3.3
        try {
            acc1.withdraw(-100);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        

        //3.4
        try {
            acc1.withdraw(1500);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    
        //3.5
        acc1.freezeAccount();
        try {
            acc1.withdraw(500);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        acc1.unfreezeAccount();

        //3.6
        accM1.filterTransactionsAtOrAbove(200, acc1.getTransactionHistory());

        //3.7
        accM1.sortTransactionsByAmount(acc1.getTransactionHistory());
    }
}