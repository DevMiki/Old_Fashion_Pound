import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        return new Amount(new Penny(pennies), new Shilling(shillings), new Pound(pounds));
    }

    public static int toBaseUnit(String amountToCompute) {
        final List<String> allMatches = new ArrayList<>();
        Matcher matcher = Pattern.compile("(\\d+)p (\\d+)s (\\d+)d")
                .matcher(amountToCompute);
        while (matcher.find()) {
            allMatches.add(matcher.group(1));
            allMatches.add(matcher.group(2));
            allMatches.add(matcher.group(3));
        }
        return Integer.parseInt(allMatches.get(0))*240
                +Integer.parseInt(allMatches.get(1))*12
                +Integer.parseInt(allMatches.get(2));
    }


    public Amount sum(Amount amountToCompute) {
        final Penny penny = new Penny(this.penny.getPenny() + amountToCompute.penny.getPenny());
        final Shilling shilling = new Shilling(this.shilling.getShilling() + amountToCompute.shilling.getShilling());
        final Pound pound = new Pound(this.pound.getPound() + amountToCompute.pound.getPound());
        return Amount.fromBaseUnit(penny.toSmallestUnit() + shilling.toSmallestUnit() + pound.toSmallestUnit());
    }

    public Amount sumByString(String amountToCompute) {
        return Amount.fromBaseUnit(penny.toSmallestUnit() + shilling.toSmallestUnit() + pound.toSmallestUnit()+Amount.toBaseUnit(amountToCompute));
    }

    public Amount subtract(Amount amountToSubtract) {
        final Penny penny = new Penny(this.penny.getPenny() - amountToSubtract.penny.getPenny());
        final Shilling shilling = new Shilling(this.shilling.getShilling() - amountToSubtract.shilling.getShilling());
        final Pound pound = new Pound(this.pound.getPound() - amountToSubtract.pound.getPound());
        if ((penny.toSmallestUnit() + shilling.toSmallestUnit() + pound.toSmallestUnit()) < 0) {
            throw new RuntimeException(String.format("Your amount is below the 0 pennies: %s", Amount.fromBaseUnit(penny.toSmallestUnit() + shilling.toSmallestUnit() + pound.toSmallestUnit())));
        }
        return Amount.fromBaseUnit(penny.toSmallestUnit() + shilling.toSmallestUnit() + pound.toSmallestUnit());
    }

    public Amount divide(int denominator) {
        final int totalPennies = penny.toSmallestUnit() + shilling.toSmallestUnit() + pound.toSmallestUnit();
        final double result = totalPennies * 1.0 / denominator;
        final String rest = Math.round((result - (int) result) * denominator) > 1 ? fromBaseUnit((int) Math.round((result - (int) result) * denominator)).toString() : "0";

        System.out.println(String.format("Your rest is %s", rest));
        return Amount.fromBaseUnit((int) result);
    }

    public Amount multiply(int multiplier) {
        final int totalPennies = penny.toSmallestUnit() + shilling.toSmallestUnit() + pound.toSmallestUnit();
        return Amount.fromBaseUnit(totalPennies * multiplier);
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
