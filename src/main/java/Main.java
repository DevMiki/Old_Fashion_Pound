public class Main {


    public static void main(String[] args) throws Exception {
        Penny penny = new Penny(1);
        Shilling shilling = new Shilling(16);
        Pound pound = new Pound(18);

        Penny penny1 = new Penny(10);
        Shilling shilling1 = new Shilling(4);
        Pound pound1 = new Pound(3);

        Amount amount = new Amount(penny,shilling,pound);
        Amount amount1 = new Amount(penny1,shilling1,pound1);
        System.out.println(amount.divide(15));
    }


}
