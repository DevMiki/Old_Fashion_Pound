public class Amount {

    private Penny penny;
    private Shilling shilling;
    private Pound pound;

    public Amount(Penny penny, Shilling shilling, Pound pound) {
        this.penny = penny;
        this.shilling = shilling;
        this.pound = pound;
    }

//    public int totalPennies() {
//        return penny + shilling + pound;
//    }

//    @Override
//    public String toString() {
//        int pounds = totalPennies() / 12;
//        int penniesToShilling = totalPennies() % 12;
//        int shillings = penniesToShilling / 20;
//        int pennies = penniesToShilling % 20;
//        return String.format("%sp %ss %sd", pounds, shillings, pennies);
//    }

    public Amount sum(Amount amountToCompute){
        final Penny penny = new Penny(this.penny.getPenny() + amountToCompute.penny.getPenny());
        final Shilling shilling = new Shilling(this.shilling.getShilling() + amountToCompute.shilling.getShilling());
        final Pound pound = new Pound(this.pound.getPound() + amountToCompute.pound.getPound());
        return new Amount(penny,shilling,pound);
    }

//    public int getPenny() {
//        return penny;
//    }
//
//    public void setPenny(int penny) {
//        this.penny = penny;
//    }
//
//    public int getShilling() {
//        return shilling;
//    }
//
//    public void setShilling(int shilling) {
//        this.shilling = shilling;
//    }
//
//    public int getPound() {
//        return pound;
//    }
//
//    public void setPound(int pound) {
//        this.pound = pound;
//    }
}
