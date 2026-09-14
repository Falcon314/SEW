package jhahn.accounts;
import jhahn.myExceptions.NegativeBalanceException;
import jhahn.playerContent.*;

public class PremiumAccount extends Account{
    private int premiumFee;
    private double discountRate;
    private boolean feeCharged;

    /**
     * Konstruiert ein PremiumAccount mit Standardwerten.
     * @throws NegativeBalanceException wenn das Guthaben negativ ist
     * @throws IllegalArgumentException wenn Parameter ungültig sind
     */
    public PremiumAccount() throws NegativeBalanceException, IllegalArgumentException{
        super();
        this.setDiscountRate(0.1);
        this.setPremiumFee(10);
    }

    /**
     * Konstruiert ein PremiumAccount mit den angegebenen Werten.
     * @param accountId die Account-ID
     * @param balance das anfängliche Guthaben
     * @param maxItems die maximale Anzahl von Items
     * @param premiumFee die monatliche Gebühr
     * @param discountRate der Rabattsatz
     * @throws NegativeBalanceException wenn das Guthaben negativ ist
     * @throws IllegalArgumentException wenn Parameter ungültig sind
     */
    public PremiumAccount(int accountId, int balance, int maxItems, int premiumFee, double discountRate) throws NegativeBalanceException, IllegalArgumentException{
        super(accountId,balance,maxItems);
        this.setDiscountRate(discountRate);
        this.setPremiumFee(premiumFee);
        this.setFeeCharged(false);
    }

    /**
     * Gibt die monatliche Gebühr zurück.
     * @return die Gebühr
     */
    public int getPremiumFee() {
        return premiumFee;
    }

    /**
     * Setzt die monatliche Gebühr, wenn sie nicht-negativ ist. Wirft eine IllegalArgumentException, wenn die Gebühr negativ ist.
     * @param premiumFee die zu setzende Gebühr
     * @throws IllegalArgumentException wenn die Gebühr negativ ist
     */
    public void setPremiumFee(int premiumFee) throws IllegalArgumentException {
        if (premiumFee < 0) throw new IllegalArgumentException("Premium fee must be non-negative");
        this.premiumFee = premiumFee;
    }

    /**
     * Gibt den Rabattsatz zurück.
     * @return der Rabattsatz
     */
    public double getDiscountRate() {
        return discountRate;
    }

    /**
     * Setzt den Rabattsatz, wenn er zwischen 0.0 und 1.0 liegt. Wirft eine IllegalArgumentException, wenn der Wert außerhalb dieses Bereichs ist.
     * @param discountRate der zu setzende Rabattsatz
     * @throws IllegalArgumentException wenn der Rabattsatz nicht zwischen 0.0 und 1.0 liegt
     */
    public void setDiscountRate(double discountRate) throws IllegalArgumentException {
        if (discountRate < 0.0 || discountRate > 1.0) throw new IllegalArgumentException("Discount rate must be between 0.0 and 1.0");
        this.discountRate = discountRate;
    }

    /**
     * Gibt zurück, ob die Gebühr bereits belastet wurde.
     * @return true, wenn belastet, sonst false
     */
    public boolean getFeeCharged() {
        return feeCharged;
    }

    /**
     * Setzt, ob die Gebühr belastet wurde.
     * @param feeCharged der Status der Gebühr
     */
    public void setFeeCharged(boolean feeCharged) {
        this.feeCharged = feeCharged;
    }

    /**
     * Belastet die monatliche Gebühr, wenn sie noch nicht belastet wurde und das Guthaben ausreicht.
     * @throws NegativeBalanceException wenn das Guthaben nach der Belastung negativ wäre
     */
    public void chargeMonthlyFee() throws NegativeBalanceException {
        if (this.feeCharged) return;
        if (super.getBalance() >= this.premiumFee) {
            super.setBalance(super.getBalance() - this.premiumFee);
            setFeeCharged(true);
        }
    }

    /**
     * Kauft ein Item mit Rabatt.
     * @param item das zu kaufende Item
     * @return true, wenn gekauft, sonst false
     */
    @Override
    public boolean buyItem(Item item) {
        if (item == null) return false;
        int discountedPrice = (int) (item.getCost() * (1.0 - this.discountRate));
        //item.setCost(discountedPrice); statt item neu zu bepreisen, neu erstellen mit Rabatt
        item = new Item(item.getName(), discountedPrice); // kann den Preis des Items nicht negativ machen, da discountRate zwischen 0.0 und 1.0 liegt
        return super.buyItem(item);
    }

    /**
     * Gibt eine String-Darstellung des PremiumAccounts zurück.
     * @return die String-Darstellung
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(" - Premium-Account (")
                .append(this.premiumFee).append("/Monat; ").append(this.discountRate*100)
                .append("% Rabatt");
        if (!this.feeCharged) sb.append("; noch nicht bezahlt)");
        else sb.append(") bezahlt");
        return sb.toString();


    }

    /**
     * Gibt den Hash-Code für diesen PremiumAccount zurück.
     * @return der Hash-Code
     */
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + premiumFee;
        result = 31 * result + (int) (discountRate);
        return result;
    }

    /**
     * Vergleicht diesen PremiumAccount mit einem anderen auf Gleichheit.
     * @param obj das andere Objekt zum Vergleich
     * @return true, wenn gleich, sonst false
     */
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        PremiumAccount that = (PremiumAccount) obj;
        return this.premiumFee == that.premiumFee &&
               Double.compare(this.discountRate, that.discountRate) == 0 &&
               this.feeCharged == that.feeCharged;
    }
}
