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
}
