package dk.via.tax;

import java.util.List;

public class TaxingFunctional {
    @FunctionalInterface
    interface TaxCalculatorStrategy {
        double calculateTaxRate(Good good);
    }

    private static Money totalWithSalesTax(List<Good> goods, String currency, TaxCalculatorStrategy calc) {
        Money total = Money.zero(currency);
        for(Good good: goods) {
            double taxRate = calc.calculateTaxRate(good);
            total = total.add(good.getPrice().multiply(1 + taxRate));
        }
        return total;
    }

    private static double totalWithDanishSalesTaxStream(List<Good> goods, String currency, TaxCalculatorStrategy calc) {
        return goods.stream()
                .map(good -> good.getPrice())
                .map(price -> price.multiply(1.25))
                .mapToDouble(price -> price.getAmount().doubleValue())
                .sum();
    }

    public static Money totalWithDanishSalesTax(List<Good> goods) {
        return totalWithSalesTax(goods, "DKK", good -> .25);
    }

    public static Money totalWithGermanSalesTax(List<Good> goods) {
        return totalWithSalesTax(goods, "EUR", good -> {
            if (good.getCategory().equals("Food"))
                return .07;
            else
                return .19;
        });
    }
}
