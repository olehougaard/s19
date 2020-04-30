package dk.via.mutable;

import java.util.Objects;

public final class Good {
    private String name;
    private String category;
    private Money price;

    public Good(String name, String category, Money price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public Money getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Good good = (Good) o;
        return name.equals(good.name) &&
                category.equals(good.category) &&
                price.equals(good.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category, price);
    }
}
