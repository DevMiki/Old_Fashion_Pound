package klepin;
import klepin.Currencies.*;

import java.util.Arrays;

public class Amount {

    private int units;

    public Amount(CurrencyUnit... currencyUnits){
        units = Arrays
                .stream(currencyUnits)
                .mapToInt(CurrencyUnit::toBaseCurrency)
                .sum();
    }
}
