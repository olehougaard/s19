package dk.via.salessystem;

public class Salesperson {
    private String name;
    private int percentOfQuota;
    private int salary;

    public Salesperson(String name, int percentOfQuota, int salary) {
        this.name = name;
        this.percentOfQuota = percentOfQuota;
        this.salary = salary;
    }

    public String getName() { return name; }

    public int getPercentOfQuota() {
        return percentOfQuota;
    }

    public void setPercentOfQuota(int percentOfQuota) {
        this.percentOfQuota = percentOfQuota;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Salesperson{" +
                "name='" + name + '\'' +
                ", percentOfQuota=" + percentOfQuota +
                ", salary=" + salary +
                '}';
    }
}
