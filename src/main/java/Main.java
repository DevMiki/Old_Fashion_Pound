public class Main {


    public static void main(String[] args) {
        Penny penny = new Penny(8);
        Shilling shilling = new Shilling(17);
        Pound pound = new Pound(5);

        Penny penny1 = new Penny(10);
        Shilling shilling1 = new Shilling(4);
        Pound pound1 = new Pound(3);

        Amount amount = new Amount(penny,shilling,pound);
        Amount amount1 = new Amount(penny1,shilling1,pound1);
        System.out.println(amount.sum(amount1));
    }


}
