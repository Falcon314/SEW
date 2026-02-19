package jhahn;
import java.util.Random;

public class Account {
    private int accountId;
    private int balance;
    private int maxItems;
    private Item[] inventory;

    public Account(int accountId, int balance, int maxItems) {
        setAccountId(1111);
        setBalance(0);
        setAccountId(accountId);
        setBalance(balance);
        if (maxItems > 0)
            this.setMaxItems(maxItems);
        else
            this.setMaxItems(10);
        this.inventory = new Item[0];

    }
    public Account() {
        this(1000+new Random().nextInt(9000) , 0, 10);
    }


    public int getAccountId() {
        return accountId;
    }
    public void setAccountId(int accountId) {
        if (accountId >= 0) {
            this.accountId = accountId;
        }
    }

    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        if (balance>=0) {
            this.balance = balance;
        }
    }

    public int getMaxItems() {
        return maxItems;
    }
    public void setMaxItems(int maxItems) {
        if (maxItems > 0) {
            this.maxItems = maxItems;
        }
    }

    public Item getItem(int index) {
        if (index >= 0 && index < this.inventory.length) {
            return this.inventory[index];
        }
        return null;
    }
    public void setItem(int index, Item item) {
        if (index >= 0 && index < this.inventory.length) {
            this.inventory[index] = item;
        }
    }

    public boolean buyItem(Item item) {
        if (item == null || balance < item.getCost()) {
            return false;
        }
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] == null) {
                inventory[i] = item;
                balance -= item.getCost();
                return true;
            }
        }
        if (inventory.length < maxItems) {
            Item[] newInventory = new Item[inventory.length + 1];
            for (int i = 0; i < inventory.length; i++) {
                newInventory[i] = inventory[i];
            }
            newInventory[inventory.length] = item;
            inventory = newInventory;
            balance -= item.getCost();
            return true;
        }
        return false;
    }

    public String accountData() {
        StringBuilder sb = new StringBuilder();
        sb.append("Account #").append(this.getAccountId())
                .append(" - Guthaben: ").append(this.getBalance())
                .append(" Gold | Inventar: ");
        if (this.inventory != null && inventory.length >0) {
            for (int i = 0; i < this.inventory.length - 1; i++) {
                if (this.inventory[i] != null) {
                    sb.append(this.inventory[i].itemData()).append(", ");

                }
            }
            if (this.inventory[inventory.length - 1] != null) {
                sb.append(this.inventory[inventory.length - 1].itemData());
            }
        } else {
            sb.append("leer");
        }
        return sb.toString();
    }sout
}
