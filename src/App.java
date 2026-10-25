import account.BankAccount;
import account.SavingsAccount;
import account.BankAccountManager;

public class App {
    public static void main(String[] args) throws Exception {
        BankAccount acc1 = new SavingsAccount("Test0");

        System.out.println("Activity 1 Test Cases");
        if (acc1 instanceof SavingsAccount savingsAcc) {
            System.out.println("Account Owner: " + savingsAcc.getOwnerName() + ".");
        }
        acc1.deposit(1000.125);
        acc1.deposit(0);
        acc1.deposit(-500);
        acc1.withdraw(500);
        acc1.withdraw(1500);
        acc1.withdraw(-100);
        acc1.freezeAccount();
        acc1.deposit(11500);
        acc1.withdraw(500);
        acc1.unfreezeAccount();
        acc1.withdraw(100);

        System.out.println("\nActivity 2 Test Cases");

        // 2.1
        System.out.println("Test Case 1:");
        System.out.println("Transaction history: " + acc1.getTransactionHistory());

        // 2.2
        System.out.println("\nTest Case 2:");
        BankAccountManager accM1 = new BankAccountManager();
        System.out.println("BankAccountManager created successfully.");

        // 2.3
        System.out.println("\nTest Case 3:");
        accM1.addAccount(acc1);

        // 2.4
        System.out.println("\nTest Case 4:");
        accM1.addAccount(new SavingsAccount("Test1"));

        // 2.5
        System.out.println("\nTest Case 5:");
        accM1.listAccounts();
    }
}