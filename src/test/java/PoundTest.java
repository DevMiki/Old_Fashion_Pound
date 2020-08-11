import it.core.currencies.Pound;
import org.junit.Assert;
import org.junit.Test;

public class PoundTest {

    @Test
    public void canConvertToBaseUnit(){
        final int actual = new Pound(10).toSmallestUnit();
        final int expected = 2400;

        Assert.assertEquals(expected,actual);
    }
}
