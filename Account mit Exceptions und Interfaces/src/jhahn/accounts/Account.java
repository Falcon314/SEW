package jhahn.accounts;
import jhahn.playerContent.*;
import jhahn.myExceptions.*;

import java.util.Random;
import java.util.Objects;

public class Account implements UserAccount, Identifizierbar {
    private int accountId;
    private int balance;
    private int maxItems;
    private Item[] inventory;

    /**
     * Konstruiert ein Account mit der angegebenen Account-ID,
     * Guthaben und maximalen Anzahl von Items.
     * @param accountId die Account-ID
     * @param balance das anfängliche Guthaben
     * @param maxItems die maximale Anzahl von Items im Inventar
     * @throws NegativeBalanceException wenn das Guthaben negativ ist
     * @throws IllegalArgumentException wenn maxItems ungültig ist
     */
    public Account(int accountId, int balance, int maxItems) throws NegativeBalanceException, IllegalArgumentException{
        if (maxItems <= 0) throw new IllegalArgumentException("Max items have to be positive");
        setAccountId(accountId);
        setBalance(balance);
        setMaxItems(maxItems);
        this.inventory = new Item[0];
    }

    /**
     * Konstruiert ein Account mit Standardwerten: zufällige Account-ID zwischen 1000-9999, Guthaben 0, maxItems 10.
     * @throws NegativeBalanceException wenn das Guthaben negativ ist (obwohl Standard 0 ist)
     * @throws IllegalArgumentException wenn maxItems ungültig ist (obwohl Standard 10 ist)
     */
    public Account() throws NegativeBalanceException, IllegalArgumentException {
        this(1000+new Random().nextInt(9000) , 0, 10);
    }

    /**
     * Gibt die Account-ID zurück.
     * @return die Account-ID
     */
    public int getAccountId() {
        return accountId;
    }

    /**
     * Setzt die Account-ID, wenn sie nicht-negativ ist.
     * @param accountId die zu setzende Account-ID
     */
    public void setAccountId(int accountId) throws IllegalArgumentException {
        if (accountId<0) throw new IllegalArgumentException("Account ID have to be positive");
        this.accountId = accountId;
    }

    /**
     * Erhöht das Guthaben um den angegebenen Upload-Credit-Betrag.
     * @param uploadCredit der Betrag, der zum Guthaben hinzugefügt werden soll
     */
    @Override
    public void increaseBalance(double uploadCredit) throws IllegalArgumentException {
        if (uploadCredit<0) throw new IllegalArgumentException("Upload credit has to be positive");
        this.balance += (int) uploadCredit;
    }

    /**
     * Gibt das aktuelle Guthaben zurück.
     * @return das Guthaben
     */
    @Override
    public int getBalance() {
        return balance;
    }

    /**
     * Setzt das Guthaben, wenn es nicht-negativ ist.
     * @param balance das zu setzende Guthaben
     * @throws NegativeBalanceException wenn das Guthaben negativ ist
     */
    public void setBalance(int balance) throws NegativeBalanceException {
        if (balance<0) throw new NegativeBalanceException("Balance has to be positive");
        this.balance = balance;
    }

    /**
     * Gibt die maximale Anzahl von Items zurück, die im Inventar erlaubt sind.
     * @return die max Items
     */
    public int getMaxItems() {
        return maxItems;
    }

    /**
     * Setzt die maximale Anzahl von Items, wenn sie positiv ist.
     * @param maxItems die zu setzenden max Items
     */
    public void setMaxItems(int maxItems) throws IllegalArgumentException {
        if (maxItems < 0) throw new IllegalArgumentException("Max items have to be positive");
        this.maxItems = maxItems;
    }

    /**
     * Setzt ein Item an dem angegebenen Index im Inventar, wenn der Index gültig ist.
     * @param index der Index, an dem das Item gesetzt werden soll
     * @param item das zu setzende Item
     * @throws ArrayIndexOutOfBoundsException wenn der Index außerhalb der Inventargrenzen liegt
     */
    public void setItem(int index, Item item) throws ArrayIndexOutOfBoundsException {
        if (index >= 0 && index < this.inventory.length) {
            this.inventory[index] = item;
        } else {
            throw new ArrayIndexOutOfBoundsException("Index out of inventory bounds");
        }
    }

    /**
     * Gibt das Inventar-Array zurück.
     * @return das Inventar
     */
    public Item[] getInventory() {
        return inventory;
    }

    /**
     * Versucht, ein Item zu kaufen, wenn das Guthaben ausreicht und Platz im Inventar vorhanden ist.
     * @param item das zu kaufende Item
     * @return true, wenn das Item gekauft wurde, sonst false
     */
    @Override
    public boolean buyItem(Item item) {
        if (item == null || balance < item.getCost()) {
            return false;
        }
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] == null) {
                inventory[i] = item;
                balance -= item.getCost(); // kann nicht negativ werden, da vorher geprüft wurde, dass genug Guthaben vorhanden ist
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
            balance -= item.getCost(); // kann nicht negativ werden, da vorher geprüft wurde, dass genug Guthaben vorhanden ist
            return true;
        }
        return false;
    }

    /**
     * Gibt eine String-Darstellung des Accounts zurück.
     * @return die String-Darstellung
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Account #").append(this.accountId)
                .append(" - Guthaben: ").append(this.balance)
                .append(" Gold | Inventar: ");
        if (this.inventory != null && this.inventory.length >0) {
            for (int i = 0; i < this.inventory.length - 1; i++) {
                if (this.inventory[i] != null) {
                    sb.append(this.inventory[i]).append(", ");

                }
            }
            if (this.inventory[inventory.length - 1] != null) {
                sb.append(this.inventory[inventory.length - 1]);
            }
        } else {
            sb.append("leer");
        }
        return sb.toString();
    }

    /**
     * Gibt den Hash-Code für diesen Account zurück.
     * @return der Hash-Code
     */
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + accountId;
        result = 31 * result + balance;
        result = 31 * result + maxItems;
        if (inventory != null) {
            for (Item item : inventory) {
                result = 31 * result + (item != null ? item.hashCode() : 0);
            }
        }
        return result;
    }

    /**
     * Vergleicht diesen Account mit einem anderen auf Gleichheit.
     * @param obj der andere Account zum Vergleich
     * @return true, wenn gleich, sonst false
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) return false;
        Account that = (Account) obj;
        if (this == that) return true;

        if (this.accountId != that.accountId ||
            this.balance != that.balance ||
            this.maxItems != that.maxItems) return false;

        Item[] inv1 = this.inventory;
        Item[] inv2 = that.inventory;
        if (inv1 == null || inv2 == null) return inv1 == inv2;
        if (inv1.length != inv2.length) return false;
        for (int i = 0; i < inv1.length; i++) {
            if (!Objects.equals(inv1[i], inv2[i])) return false;
        }
        return true;
    }

    /**
     * Gibt den Identifier für diesen Account zurück, mit führenden Nullen auf 10 Stellen aufgefüllt.
     * @return der Identifier-String
     */
    @Override
    public String identifier() {
        int aIdLaenge = String.valueOf(this.accountId).length();
        StringBuilder sb = new StringBuilder();
        sb.append("0".repeat(Math.max(0, 10 - aIdLaenge)));
        sb.append(this.accountId);
        return sb.toString();
    }
}
