package dk.via.salessystem;

public class Order {
    private int number;
    private Salesperson salesperson;
    private Customer customer;
    private int amount;

    public Order(int number, Salesperson salesperson, Customer customer, int amount) {
        this.number = number;
        this.salesperson = salesperson;
        this.customer = customer;
        this.amount = amount;
    }

    public int getNumber() {
        return number;
    }

    public Salesperson getSalesperson() {
        return salesperson;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "number=" + number +
                ", salesperson=" + salesperson +
                ", customer=" + customer +
                ", amount=" + amount +
                '}';
    }
}
