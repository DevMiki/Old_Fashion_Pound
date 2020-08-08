import java.util.Objects;

public class Penny implements CurrencyUnit{

    private int penny;

    public Penny(int penny) {
        this.penny = penny;
    }

    @Override
    public int toSmallestUnit() {
        return penny;
    }

    public int getPenny() {
        return penny;
    }

    public void setPenny(int penny) {
        this.penny = penny;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Penny penny1 = (Penny) o;
        return penny == penny1.penny;
    }

    @Override
    public int hashCode() {
        return Objects.hash(penny);
    }
}
