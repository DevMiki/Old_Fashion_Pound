import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;

public class AmountTest {
    private static final Amount firstAmount = new Amount(new Penny(8), new Shilling(17), new Pound(5));
    private static final Amount secondAmount = new Amount(new Penny(10), new Shilling(4), new Pound(3));
    private static final Amount thirdAmount =  new Amount(new Penny(8), new Shilling(17), new Pound(5));
    private static final Amount fourthAmount = new Amount(new Penny(2),new Shilling(19),new Pound(1));

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
        final Amount expected = new Amount(new Penny(6),new Shilling(2),new Pound(9));
        final Amount actual = firstAmount.sum(secondAmount);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void canSubtractCurrencies() throws Exception {
        final Amount expected = new Amount(new Penny(10),new Shilling(12),new Pound(2));
        final Amount actual = firstAmount.subtract(secondAmount);
        Assert.assertEquals(expected, actual);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void canSubtractCurrency() {
        thrown.expect(java.lang.Exception.class);
        thrown.expectMessage("Your amount is below the 0 pennies: -2p -3s -2d");
        thrown.expectCause(is(new java.lang.Exception().getCause()));

        Amount firstAmount = new Amount(new Penny(8), new Shilling(1), new Pound(1));
        Amount secondAmount = new Amount(new Penny(10), new Shilling(4), new Pound(3));
        final Amount expected = new Amount(new Penny(-1),new Shilling(-1),new Pound(-2));
        final Amount actual = firstAmount.subtract(secondAmount);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void canDivideCurrency(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        String expectedOutput ="Your rest is 0p 0s 2d";
        final Amount actual = thirdAmount.divide(3);
        Assert.assertEquals(expectedOutput+"\n", outputStream.toString());
        Assert.assertEquals(fourthAmount,actual);
    }

    @Test
    public void canMultiplyCurrency(){
        final Amount expected = new Amount(new Penny(4),new Shilling(15),new Pound(11));
        final Amount actual = thirdAmount.multiply(2);
        Assert.assertEquals(expected,actual);
    }
}