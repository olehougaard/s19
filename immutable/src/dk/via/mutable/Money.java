package dk.via.mutable;

import java.util.Objects;

public final class Money {
    private double amount;
    private String currency;

    public Money(double amount, String currency) {
        if (currency == null) throw new NullPointerException();
        this.amount = amount;
        this.currency = currency;
    }

    public static Money zero(String currency) {
        return new Money(0, currency);
    }

    public double getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount==(money.amount) &&
                currency.equals(money.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, currency);
    }

    public Money add(Money money) {
        if (currency.equals(money.getCurrency()))
            return new Money(amount + money.getAmount(), currency);
        else
            throw new IllegalArgumentException();
    }

    public Money multiply(double factor) {
        return new Money(amount * factor, currency);
    }
}
