import it.core.currencies.Shilling;
import org.junit.Assert;
import org.junit.Test;

public class ShillingTest {

    @Test
    public void canConvertToBaseUnit(){
        final int actual = new Shilling(20).toSmallestUnit();
        final int expected = 240;

        Assert.assertEquals(expected,actual);
    }
}
