package jhahn.accounts;
import jhahn.playerContent.*;

public class PremiumAccount extends Account{
    private int premiumFee;
    private double discountRate;
    private boolean feeCharged;

    public PremiumAccount() {
        super();
        this.setDiscountRate(0.1);
        this.setPremiumFee(10);
    }
    public PremiumAccount(int accountId, int balance, int maxItems, int premiumFee, double discountRate) {
        super(accountId,balance,maxItems);
        this.setDiscountRate(discountRate);
        this.setPremiumFee(premiumFee);
        this.setFeeCharged(false);
    }

    public int getPremiumFee() {
        return premiumFee;
    }
    public void setPremiumFee(int premiumFee) {
        if (premiumFee >= 0) {
            this.premiumFee = premiumFee;
        }
    }

    public double getDiscountRate() {
        return discountRate;
    }
    public void setDiscountRate(double discountRate) {
        if (discountRate >= 0.0 && discountRate <=1.0) {
            this.discountRate = discountRate;
        }
    }

    public boolean getFeeCharged() {
        return feeCharged;
    }
    public void setFeeCharged(boolean feeCharged) {
        this.feeCharged = feeCharged;
    }

    public void chargeMonthlyFee() {
        if (this.getFeeCharged()) return;

        if (super.getBalance() >= this.getPremiumFee()) {
            super.setBalance(super.getBalance() - this.getPremiumFee());
            setFeeCharged(true);
        }
    }

    @Override
    public boolean buyItem(Item item) {
        if (item == null) return false;
        int discountedPrice = (int) (item.getCost() * (1.0 - this.getDiscountRate()));
        item.setCost(discountedPrice);
        return super.buyItem(item);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(" - Premium-Account (")
                .append(this.getPremiumFee()).append("/Monat; ").append(this.getDiscountRate()*100)
                .append("% Rabatt");
        if (!this.getFeeCharged()) sb.append("; noch nicht bezahlt)");
        else sb.append(") bezahlt");
        return sb.toString();


    }

    @Override
    public int hashCode() {
        return super.hashCode() + this.premiumFee + (int) this.discountRate;
    }

    public boolean equals(PremiumAccount that) {
        if (this == that) return true;
        if (that == null) return false;

        if (this.getAccountId() != that.getAccountId()) return false;
        if (this.getBalance() != that.getBalance()) return false;
        if (this.getMaxItems() != that.getMaxItems()) return false;

        Item[] inv1 = this.getInventory();
        Item[] inv2 = that.getInventory();

        if (inv1 == null && inv2 != null) return false;
        if (inv1 != null && inv2 == null) return false;
        if (inv1 == null && inv2 == null) return true;

        if (inv1.length != inv2.length) return false;

        for (int i = 0; i < inv1.length; i++) {
            Item item1 = inv1[i];
            Item item2 = inv2[i];

            if (item1 == null && item2 != null) return false;
            if (item1 != null && !item1.equals(item2)) return false;
        }

        return true;
    }
}
