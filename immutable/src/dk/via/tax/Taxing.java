package dk.via.tax;

import java.util.List;

public class Taxing {
    interface TaxCalculatorStrategy {
        double calculateTaxRate(Good good);
    }

    static class DanishTaxCalculator implements TaxCalculatorStrategy {
        @Override
        public double calculateTaxRate(Good good) {
            return .25;
        }
    }

    static class GermanTaxCalculator implements TaxCalculatorStrategy {
        @Override
        public double calculateTaxRate(Good good) {
            if (good.getCategory().equals("Food"))
                return .07;
            else
                return .19;
        }
    }

    private static Money totalWithSalesTax(List<Good> goods, String currency, TaxCalculatorStrategy calc) {
        Money total = Money.zero(currency);
        for(Good good: goods) {
            double taxRate = calc.calculateTaxRate(good);
            total = total.add(good.getPrice().multiply(1 + taxRate));
        }
        return total;
    }

    public static Money totalWithDanishSalesTax(List<Good> goods) {
        return totalWithSalesTax(goods, "DKK", new DanishTaxCalculator());
    }

    public static Money totalWithGermanSalesTax(List<Good> goods) {
        return totalWithSalesTax(goods, "EUR", new GermanTaxCalculator());
    }
}
