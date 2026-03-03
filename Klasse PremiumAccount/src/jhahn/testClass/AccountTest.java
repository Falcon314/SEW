package jhahn.testClass;
import jhahn.playerContent.*;
import jhahn.accounts.*;

public class AccountTest {
    public static void main(String[] args) {
        Account account1 = new Account(1111, 1000,3);
        System.out.println(account1.accountData());
        for (int i = 0; i < 4; i++) {
            account1.buyItem(new Item("Trank"+i, i));
            System.out.println(account1.accountData());
        }
        System.out.println(account1.accountData());

        PremiumAccount premiumAccount = new PremiumAccount(2222, 1000, 3,10,0.15);

        System.out.println(premiumAccount.accountData());
        for (int i = 0; i < 4; i++) {
            premiumAccount.buyItem(new Item("Trank", 99));
            System.out.println(premiumAccount.accountData());
        }
        premiumAccount.chargeMonthlyFee();
        System.out.println(premiumAccount.accountData());
        System.out.println("----- Test von toString() und equals() aus der Klasse Object -----");
        Account player1 = new Account(01, 100, 10);
        System.out.println("Account: " + player1);
        Account player2 = new Account(01, 100, 10);
        System.out.println("Vergleich: " + player1.equals(player2));
    }
}
