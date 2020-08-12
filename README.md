### Old Fashion it.core.currencies.Pound

This library allows you to use the 4 fundamental operations (sum,division,subtraction,multiplication) according to the old english monetary system used before the 70'.

#### Legend
- p = Pounds
- s = Shellings
- d = Pennies
- result = Xp Ys Zd

Example: *12p 6s 10d* equals to 12 pounds, 6 shellings and 10 pennies.

Notes:
- that the result after a division operation will be shown as follows: *Xp Ys Zd (Xp Ys Zd)*.  
Inside the parentheses will be shown the rest.
- The subtract operation will throw a `NegativeAmountException` if the result is negative.


-------------

### Example

```
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

      //Output: 1p 9s 9d (0p 0s 6d)
                13p 13s 7d
```



