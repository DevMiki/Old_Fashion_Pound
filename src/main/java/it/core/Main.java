package it.core;

import it.core.currencies.Penny;
import it.core.currencies.Pound;
import it.core.currencies.Shilling;

public class Main {
    public static void main(String[] args) {
        final Penny penny = new Penny(9);
        final Shilling shilling = new Shilling(8);
        final Pound pound = new Pound(10);

        final Penny penny1 = new Penny(10);
        final Shilling shilling1 = new Shilling(4);
        final Pound pound1 = new Pound(3);

        final Amount first = new Amount(penny,shilling,pound);
        final Amount second = new Amount(penny1,shilling1,pound1);
        System.out.println(first.divide(7));
        System.out.println(first.sumByString("3p 4s 10d"));
    }
}
