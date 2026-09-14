package jhahn.accounts;
import jhahn.playerContent.Item;

public interface UserAccount {
    /**
     * Diese Methode gibt das Guthaben des Accounts zurück
     * @return eine Ganzzahl für das Guthaben
     */
    public int getBalance();

    /**
     * Erhöht das Guthaben um den angegebenen Upload-Credit-Betrag.
     * @param uploadCredit der Betrag, der zum Guthaben hinzugefügt werden soll
     */
    public void increaseBalance(double uploadCredit);

    /**
     * Versucht, ein Item zu kaufen, wenn das Guthaben ausreicht und Platz im Inventar vorhanden ist.
     * @param item das zu kaufende Item
     * @return true, wenn das Item gekauft wurde, sonst false
     */
    public boolean buyItem(Item item);
}
