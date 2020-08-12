package it.core.result;

import it.core.Amount;
import java.util.Objects;

public class WholeResult implements Result {

    //only for the one who extends
    protected Amount amount;

    public WholeResult(Amount amount) {
        this.amount = amount;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WholeResult that = (WholeResult) o;
        return Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    @Override
    public String toString() {
        return amount.resultFormatter();
    }
}
