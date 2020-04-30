package dk.via.sales;

public class Order {
	private int number;
	private String salespersonName;
	private String customerName;
	private int amount;
	
	public Order(int number, String customerName, String salespersonName, int amount) {
		this.number = number;
		this.salespersonName = salespersonName;
		this.customerName = customerName;
		this.amount = amount;
	}

	public int getNumber() {
		return number;
	}

	public String getSalespersonName() {
		return salespersonName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public int getAmount() {
		return amount;
	}
}
