import org.junit.Assert;
import org.junit.Test;

public class AmountTest {
    private static final Amount firstAmount = new Amount(new Penny(8), new Shilling(17), new Pound(5));
    private static final Amount secondAmount = new Amount(new Penny(10), new Shilling(4), new Pound(3));

    @Test
    public void canSumCurrencies() {
        final Amount expected = new Amount(new Penny(6),new Shilling(2),new Pound(9));
        final Amount actual = firstAmount.sum(secondAmount);
        Assert.assertEquals(expected, actual);
    }
}