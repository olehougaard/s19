package dk.via.sales;

public class PerformJoin {
	public static void main(String[] args) {
		Customer[] customers = {
			new Customer("Abernathy Construction", "Willow", "B"),	
			new Customer("Amalgamated Housing", "Memphis", "B"),	
			new Customer("Manchester Lumber", "Manchester", "F"),	
			new Customer("Tri-City Builders", "Memphis", "B"),	
		};
		
		Order[] orders = {
			new Order(100, "Abernathy Construction", "Zenith", 560),
			new Order(200, "Abernathy Construction", "Jones", 1800),
			new Order(300, "Manchester Lumber", "Abel", 480),
			new Order(400, "Amalgamated Housing", "Abel", 2500),
			new Order(500, "Abernathy Construction", "Murphy", 6000),
			new Order(600, "Tri-City Builders", "Abel", 700),
			new Order(700, "Manchester Lumber", "Jones", 150),
		};
	
		for(Order order: orders) {
			for(Customer customer: customers) {
				if (order.getCustomerName().equals(customer.getName())) {
					System.out.print(customer.getName());
					System.out.print(", ");
					System.out.print(customer.getCity());
					System.out.print(", ");
					System.out.print(order.getSalespersonName());
					System.out.print(", ");
					System.out.println(order.getAmount());
					
				}
			}
		}
	}
}
