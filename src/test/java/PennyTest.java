import org.junit.Assert;
import org.junit.Test;

public class PennyTest {
    @Test
    public void canConvertToBaseUnit(){
        final int actual = new Penny(10).toSmallestUnit();
        final int expected=10;

        Assert.assertEquals(expected,actual);
    }
}
