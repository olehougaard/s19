package dk.via.tax;

import java.math.BigDecimal;
import java.util.Objects;

public final class Money {
    private final BigDecimal amount;
    private final String currency;

    public Money(BigDecimal amount, String currency) {
        if (amount == null || currency == null) throw new NullPointerException();
        this.amount = amount;
        this.currency = currency;
    }

    public static Money zero(String currency) {
        return new Money(BigDecimal.ZERO, currency);
    }

    public BigDecimal getAmount() {
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
        return amount.equals(money.amount) &&
                currency.equals(money.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, currency);
    }

    public Money add(Money other) {
        if (currency.equals(other.currency))
            return new Money(amount.add(other.amount), currency);
        else
            throw new IllegalArgumentException(String.format("Mismatched currency. Expected %s, got %s", currency, other.currency));
    }

    public Money multiply(double factor) {
        return new Money(amount.multiply(new BigDecimal(factor)), currency);
    }
}
