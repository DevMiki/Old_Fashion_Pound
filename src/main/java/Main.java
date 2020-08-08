public class Main {


    public static void main(String[] args) {
        Penny penny = new Penny(123);
        Shilling shilling = new Shilling(132);
        Pound pound = new Pound(10);

        Penny penny1 = new Penny(1583);
        Shilling shilling1 = new Shilling(112);
        Pound pound1 = new Pound(9);

        Amount totalPennies;
        totalPennies = Calculate.subtraction(new Amount(penny,shilling,pound),new Amount(penny1,shilling1,pound1));
        System.out.println(totalPennies);

    }


}
