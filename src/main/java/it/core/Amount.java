package it.core;

import it.core.currencies.CurrencyUnit;
import it.core.currencies.Penny;
import it.core.currencies.Pound;
import it.core.currencies.Shilling;
import it.core.result.FractionalResult;
import it.core.result.Result;
import it.core.result.WholeResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Amount {

    private final int totalBaseUnits;

    public Amount(CurrencyUnit... currencyUnits) {
        totalBaseUnits = Arrays.stream(currencyUnits)
                .mapToInt(CurrencyUnit::toSmallestUnit)
                .sum();

    }

    public static Amount fromBaseUnit(int baseUnits) {
        int pounds = baseUnits / 240;
        int remainingUnits = baseUnits % 240;
        int shillings = remainingUnits / 12;
        int pennies = remainingUnits % 12;
        return new Amount(new Penny(pennies), new Shilling(shillings), new Pound(pounds));
    }

    public static int toBaseUnit(String amountToCompute) {
        final List<String> allMatches = new ArrayList<>();
        final Matcher matcher = Pattern.compile("(\\d+)p (\\d+)s (\\d+)d")
                .matcher(amountToCompute);
        while (matcher.find()) {
            allMatches.add(matcher.group(1));
            allMatches.add(matcher.group(2));
            allMatches.add(matcher.group(3));
        }
        return Integer.parseInt(allMatches.get(0))*240
                +Integer.parseInt(allMatches.get(1))*12
                +Integer.parseInt(allMatches.get(2));
    }

    public String resultFormatter() {
        int pounds = totalBaseUnits / 240;
        int remainingUnits = totalBaseUnits % 240;
        int shillings = remainingUnits / 12;
        int pennies = remainingUnits % 12;
        return String.format("%sp %ss %sd", pounds, shillings, pennies);
    }


    public Result sum(Amount amountToCompute) {
        final int totalUnits = totalBaseUnits+ amountToCompute.totalBaseUnits;
        return new WholeResult(Amount.fromBaseUnit(totalUnits));
    }

    public Result sumByString(String amountToCompute) {
        return new WholeResult(Amount.fromBaseUnit(totalBaseUnits+toBaseUnit(amountToCompute)));
    }

    public Result subtract(Amount amountToSubtract) {

        final int result = totalBaseUnits - amountToSubtract.totalBaseUnits;
        if (result < 0) {
            throw new NegativeAmountException(String.format("Your amount is below the 0 pennies: %s", new WholeResult(Amount.fromBaseUnit(result))));
        }
        return new WholeResult(Amount.fromBaseUnit(result));
    }

    public Result divide(int denominator) {
        final double result = totalBaseUnits * 1.0 / denominator;
        final Amount rest = fromBaseUnit((int) Math.round((result - (int) result) * denominator));

        return new FractionalResult(Amount.fromBaseUnit((int) result), rest);
    }

    public Result multiply(int multiplier) {
        return new WholeResult(Amount.fromBaseUnit(totalBaseUnits * multiplier));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amount amount = (Amount) o;
        return totalBaseUnits == amount.totalBaseUnits;
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalBaseUnits);
    }

}
