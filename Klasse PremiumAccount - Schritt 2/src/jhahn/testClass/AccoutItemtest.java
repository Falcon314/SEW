package jhahn.testClass;
import jhahn.accounts.*;
import jhahn.playerContent.*;

public class AccoutItemtest {
    public static void main(String[] args) {
        PremiumAccount premiumAccount = new PremiumAccount(1111, 1000, 3, 1, 0.9);
        for (int i = 0; i < 3; i++) {
            premiumAccount.buyItem(new Item("Trank", 100));
            System.out.println(premiumAccount.accountData());
        }
        premiumAccount.setItem(0,null);
        premiumAccount.setItem(2,null);
        System.out.println(premiumAccount.accountData());
        for (int i = 0; i < premiumAccount.getInventory().length; i++) {
            System.out.println(premiumAccount.getInventory()[i]);
        }
        System.out.println("!---------------------------------------------!");
        premiumAccount.buyItem(new Item("Trank", 100));
        System.out.println(premiumAccount.getInventory()[0]);
        System.out.println(premiumAccount.getInventory()[1]);
        System.out.println(premiumAccount.getInventory()[2]);
    }
}
