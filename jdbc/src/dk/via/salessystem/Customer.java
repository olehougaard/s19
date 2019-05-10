package dk.via.salessystem;

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

    public void setCity(String city) {
        this.city = city;
    }

    public String getIndustryType() {
        return industryType;
    }

    public void setIndustryType(String industryType) {
        this.industryType = industryType;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", industryType='" + industryType + '\'' +
                '}';
    }
}
