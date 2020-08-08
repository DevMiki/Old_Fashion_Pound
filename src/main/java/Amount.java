import java.util.Objects;

public class Amount {

    private Penny penny;
    private Shilling shilling;
    private Pound pound;

    public Amount(Penny penny, Shilling shilling, Pound pound) {
        this.penny = penny;
        this.shilling = shilling;
        this.pound = pound;
    }

    public static Amount fromBaseUnit(int baseUnits) {
        int pounds = baseUnits / 240;
        int remainingUnits = baseUnits % 240;
        int shillings = remainingUnits / 12;
        int pennies = remainingUnits % 12;
        return new Amount(new Penny(pennies),new Shilling(shillings),new Pound(pounds));
    }


    public Amount sum(Amount amountToCompute){
        final Penny penny = new Penny(this.penny.getPenny() + amountToCompute.penny.getPenny());
        final Shilling shilling = new Shilling(this.shilling.getShilling() + amountToCompute.shilling.getShilling());
        final Pound pound = new Pound(this.pound.getPound() + amountToCompute.pound.getPound());
        return Amount.fromBaseUnit(penny.toSmallestUnit()+shilling.toSmallestUnit()+pound.toSmallestUnit());
    }

    @Override
    public String toString() {
        return String.format("%dp %ds %dd", pound.getPound(), shilling.getShilling(), penny.getPenny());
    }


    public Penny getPenny() {
        return penny;
    }

    public void setPenny(Penny penny) {
        this.penny = penny;
    }

    public Shilling getShilling() {
        return shilling;
    }

    public void setShilling(Shilling shilling) {
        this.shilling = shilling;
    }

    public Pound getPound() {
        return pound;
    }

    public void setPound(Pound pound) {
        this.pound = pound;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amount amount = (Amount) o;
        return Objects.equals(penny, amount.penny) &&
                Objects.equals(shilling, amount.shilling) &&
                Objects.equals(pound, amount.pound);
    }

    @Override
    public int hashCode() {
        return Objects.hash(penny, shilling, pound);
    }
}
