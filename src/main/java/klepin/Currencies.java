package klepin;

public class Currencies {

    private Currencies(){}

    public interface CurrencyUnit{
        int toBaseCurrency();
    }

    private static abstract class BaseCurrency implements CurrencyUnit{
        protected int amount;

        protected BaseCurrency(int amount) {
            this.amount = amount;
        }
    }

    public static class Penny extends BaseCurrency{

        public Penny(int amount) {
            super(amount);
        }

        @Override
        public int toBaseCurrency() {
            return amount;
        }
    }

    public static class Shilling extends BaseCurrency{

        public Shilling(int amount) {
            super(amount);
        }

        @Override
        public int toBaseCurrency() {
            return amount*20;
        }
    }

    public static class Pound extends BaseCurrency{

        public Pound(int amount) {
            super(amount);
        }

        @Override
        public int toBaseCurrency() {
            return amount*240;
        }
    }
}
