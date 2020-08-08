public class Shilling implements CurrencyUnit{

    private int shilling;

    public Shilling(int shilling) {
        this.shilling = shilling;
    }

    @Override
    public int toSmallestUnit() {
        return shilling*20;
    }

    public int getShilling() {
        return shilling;
    }

    public void setShilling(int shilling) {
        this.shilling = shilling;
    }
}

