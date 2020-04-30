package dk.via.sales;

public class Customer {
	private String name;
	private String city;
	private String industryType;
	
	public Customer(String name, String city, String industryType) {
		this.name = name;
		this.city = city;
		this.industryType = industryType;
	}

	public String getName() {
		return name;
	}

	public String getCity() {
		return city;
	}

	public String getIndustryType() {
		return industryType;
	}
}