package dk.via.salessystem;

import java.util.ArrayList;

public class Computations {
    public static double averageSalary(ArrayList<Salesperson> persons) {
        double totalSalary = 0;
        for(Salesperson person: persons) {
            totalSalary += person.getSalary();
        }
        return totalSalary / persons.size();
    }

    public static double averagePercentOfQuota(ArrayList<Salesperson> persons) {
        double totalPercentOfQuota = 0;
        for(Salesperson person: persons) {
            totalPercentOfQuota += person.getPercentOfQuota();
        }
        return totalPercentOfQuota / persons.size();
    }

    public static double percentOfQuotaDeviation(ArrayList<Salesperson> persons) {
        double average = averagePercentOfQuota(persons);
        double sumOfSquares = 0;
        for(Salesperson person: persons) {
            sumOfSquares += Math.pow(person.getPercentOfQuota() - average, 2);
        }
        return Math.sqrt(sumOfSquares);
    }

    public static double totalSalesByHighSalarySalespersonToMemphis(ArrayList<Order> orders) {
        int total = 0;
        for(Order order: orders) {
            if (order.getSalesperson().getSalary() >= 100000 && order.getCustomer().getCity().equals("Memphis")) {
                total += order.getAmount();
            }
        }
        return total;
    }
}
