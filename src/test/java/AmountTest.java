import it.core.Amount;
import it.core.NegativeAmountException;
import it.core.currencies.Penny;
import it.core.currencies.Pound;
import it.core.currencies.Shilling;
import it.core.result.FractionalResult;
import it.core.result.Result;
import it.core.result.WholeResult;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class AmountTest {
    private static final Amount firstAmount = new Amount(new Penny(8), new Shilling(17), new Pound(5));
    private static final Amount secondAmount = new Amount(new Penny(10), new Shilling(4), new Pound(3));
    private static final Amount thirdAmount =  new Amount(new Penny(8), new Shilling(17), new Pound(5));
    private static final Result fourthAmount = new FractionalResult(new Amount(new Penny(2),new Shilling(19),new Pound(1)),new Amount(new Penny(2)));

    @Test
    public void canCreateAmountFromBaseUnit(){
        final Amount expected = new Amount(new Penny(6),new Shilling(2),new Pound(9));
        final Amount actual = Amount.fromBaseUnit(2190);
        Assert.assertEquals(expected,actual);
    }


    @Test
    public void canCreatePoundFromBaseUnit(){
        final Amount expected = new Amount(new Penny(0),new Shilling(0),new Pound(1));
        final Amount actual = Amount.fromBaseUnit(240);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void canCreateShillingFromBaseUnit(){
        final Amount expected = new Amount(new Penny(0),new Shilling(1),new Pound(0));
        final Amount actual = Amount.fromBaseUnit(12);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void canSumCurrencies() {
        final Result expected = new WholeResult(new Amount(new Penny(6),new Shilling(2),new Pound(9)));
        final Result actual = firstAmount.sum(secondAmount);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void canSumCurrencies1(){
        final Result expected = new WholeResult(new Amount(new Penny(6),new Shilling(2),new Pound(9)));
        final Result actual = firstAmount.sumByString("3p 4s 10d");
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void canSumCurrencies2(){
        final Result expected = new WholeResult(new Amount(new Penny(1),new Shilling(18),new Pound(5)));
        final Result actual = firstAmount.sumByString("0p 0s 5d");
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void canSubtractCurrencies() throws Exception {
        final Result expected = new WholeResult(new Amount(new Penny(10),new Shilling(12),new Pound(2)));
        final Result actual = firstAmount.subtract(secondAmount);
        Assert.assertEquals(expected, actual);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void canSubtractCurrency() {
        thrown.expect(NegativeAmountException.class);
        thrown.expectMessage("Your amount is below the 0 pennies: -2p -3s -2d");

        Amount firstAmount = new Amount(new Penny(8), new Shilling(1), new Pound(1));
        Amount secondAmount = new Amount(new Penny(10), new Shilling(4), new Pound(3));
        final Result expected = new WholeResult(new Amount(new Penny(-2),new Shilling(-3),new Pound(-2)));
        final Result actual = firstAmount.subtract(secondAmount);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void canDivideCurrency(){
        final Result actual = thirdAmount.divide(3);
        Assert.assertEquals(fourthAmount,actual);
    }

    @Test
    public void canMultiplyCurrency(){
        final Result expected = new WholeResult(new Amount(new Penny(4),new Shilling(15),new Pound(11)));
        final Result actual = thirdAmount.multiply(2);
        Assert.assertEquals(expected,actual);
    }
}