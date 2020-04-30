package dk.via.sales;

public class Salesperson {
	private String name;
	private int percentOfQuota;
	private int salary;
	
	public Salesperson(String name, int percentOfQuota, int salary) {
		this.name = name;
		this.percentOfQuota = percentOfQuota;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public int getPercentOfQuota() {
		return percentOfQuota;
	}

	public int getSalary() {
		return salary;
	}
}
