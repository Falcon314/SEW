package jhahn.testClass;
import jhahn.myExceptions.NegativeBalanceException;
import jhahn.playerContent.Item;
import jhahn.accounts.*;

public class AccountTestZwei {
    public static void main(String[] args) throws Exception {
        // Test der Account-Klasse
        Account account1 = new Account(1111, 1000,3);
        System.out.println(account1);
        for (int i = 0; i < 4; i++) {
            account1.buyItem(new Item("Trank"+i, i));
            System.out.println(account1);
        }
        System.out.println(account1);

        // Test der PremiumAccount-Klasse
        PremiumAccount premiumAccount = new PremiumAccount(2222, 1000, 3,10,0.15);
        System.out.println(premiumAccount);
        for (int i = 0; i < 4; i++) {
            premiumAccount.buyItem(new Item("Trank", 99));
            System.out.println(premiumAccount);
        }
        premiumAccount.chargeMonthlyFee();
        System.out.println(premiumAccount);

        // Test von toString(), hashCode() und equals() aus der Klasse Object
        System.out.println("!----------------------------------------------------------------------------!");
        System.out.println("----- Test von toString(), hashCode() und equals() aus der Klasse Object -----");
        Account player1 = new Account(01, 100, 10);
        System.out.println("Account: " + player1); // toString()
        System.out.println("Account hash:");
        Account player2 = new Account(01, 100, 10);
        System.out.println("Account 1 hash:"+player1.hashCode()); // hashCode
        System.out.println("Account 2 hash:"+player2.hashCode()); // hashCode
        System.out.println("Vergleich: " + player1.equals(player2)); // equals

        // Test der NegativeBalanceException
        testNegativeBalanceException();
    }

    /**
     * Testet die NegativeBalanceException für Account und PremiumAccount.
     */
    public static void testNegativeBalanceException() {
        System.out.println("----- Test der NegativeBalanceException -----");

        // Test für Account
        try {
            Account account = new Account(1111, 100, 5);
            account.setBalance(100);
            System.out.println("Keine Exception für Account geworfen");
        } catch (NegativeBalanceException e) {
            System.out.println("NegativeBalanceException für Account gefangen: " + e.getMessage());
        }

        // Test für PremiumAccount
        try {
            PremiumAccount premiumAccount = new PremiumAccount(2222, 200, 5, 10, 0.1);
            premiumAccount.setBalance(-50);
            System.out.println("Keine Exception für PremiumAccount geworfen");
        } catch (NegativeBalanceException e) {
            System.out.println("NegativeBalanceException für PremiumAccount gefangen: " + e.getMessage());
        }
    }
}
