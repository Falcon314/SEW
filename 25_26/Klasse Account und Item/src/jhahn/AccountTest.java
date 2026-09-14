package jhahn;

public class AccountTest {
    public static void main(String[] args) {
        Account account1 = new Account(1, 99999999,10);
        System.out.println(account1.accountData());
        for (int i = 0; i < 16; i++) {
            account1.buyItem(new Item("Trank"+i, i));
            System.out.println(account1.accountData());
        }
        System.out.println(account1.accountData());
    }
}
