import account.BankAccount;
import account.SavingsAccount;
import account.Bank;
import account.BankAccountManager;
import account.Transaction;

public class App {
    public static void main(String[] args) throws Exception {
        BankAccount acc1 = new SavingsAccount("Test0");
        Transaction t = new Transaction(null, 0);

        //Test Cases 1
        // 1.01
        System.out.println("Test Case 1:");
        if (acc1 instanceof SavingsAccount savingsAcc) {
            System.out.println("Account Owner: " + savingsAcc.getOwnerName() + ".");
        }

        // 1.02
        System.out.println("\nTest Case 2:");
        acc1.deposit(1000.125);

        // 1.03
        System.out.println("\nTest Case 3:");
        acc1.deposit(0);

        // 1.04
        System.out.println("\nTest Case 4:");
        acc1.deposit(-500);

        // 1.05
        System.out.println("\nTest Case 5:");
        acc1.withdraw(500);

        // 1.06
        System.out.println("\nTest Case 6:");
        acc1.withdraw(1500);

        // 1.07
        System.out.println("\nTest Case 7:");
        acc1.withdraw(-100);

        // 1.08
        System.out.println("\nTest Case 8:");
        acc1.freezeAccount();
        acc1.deposit(11500);

        // 1.09
        System.out.println("\nTest Case 9:");
        acc1.withdraw(500);

        // 1.10
        System.out.println("\nTest Case 10:");
        acc1.unfreezeAccount();
        acc1.withdraw(100);

        //Test Cases 2
        //2.01
        BankAccountManager.getTransactionHistory("Deposit", 1000.125, null);


    }
}
