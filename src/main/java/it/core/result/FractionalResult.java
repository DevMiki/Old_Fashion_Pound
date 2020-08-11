package it.core.result;

import it.core.Amount;

public class FractionalResult extends WholeResult {


    private Amount rest;

    public FractionalResult(Amount result, Amount rest) {
        super(result);
        this.rest = rest;
    }

    @Override
    public String toString() {
        return String.format("%s (%s)",amount.resultFormatter(), rest.resultFormatter());
    }
}
