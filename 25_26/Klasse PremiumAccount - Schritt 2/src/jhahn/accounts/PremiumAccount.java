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
    public String accountData() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.accountData()).append(" - Premium-Account (")
                .append(this.getPremiumFee()).append("/Monat; ").append(this.getDiscountRate()*100)
                .append("% Rabatt");
        if (!this.getFeeCharged()) sb.append("; noch nicht bezahlt)");
        else sb.append(") bezahlt");
        return sb.toString();


    }
}
