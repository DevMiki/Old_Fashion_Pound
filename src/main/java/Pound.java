import java.util.Objects;

public class Pound implements CurrencyUnit{

    private int pound;

    public Pound(int pound) {
        this.pound = pound;
    }

    @Override
    public int toSmallestUnit() {
        return pound*240;
    }

    public int getPound() {
        return pound;
    }

    public void setPound(int pound) {
        this.pound = pound;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pound pound1 = (Pound) o;
        return pound == pound1.pound;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pound);
    }
}
