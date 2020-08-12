package it.core.currencies;

import java.util.Objects;

public class Shilling implements CurrencyUnit {

    private int shilling;

    public Shilling(int shilling) {
        this.shilling = shilling;
    }

    public int getShilling() {
        return shilling;
    }

    public void setShilling(int shilling) {
        this.shilling = shilling;
    }

    @Override
    public int toSmallestUnit() {
        return shilling * 12;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shilling shilling1 = (Shilling) o;
        return shilling == shilling1.shilling;
    }

    @Override
    public int hashCode() {
        return Objects.hash(shilling);
    }
}

