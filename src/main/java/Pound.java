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
}
