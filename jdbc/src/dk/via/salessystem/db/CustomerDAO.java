package dk.via.salessystem.db;

import dk.via.salessystem.Customer;
import org.postgresql.Driver;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAO {
    static {
        try {
            DriverManager.registerDriver(new Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Customer create(String name, String city, String industryType) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/postgres?currentSchema=sales_system", "postgres", "password");
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Customer VALUES(?,?,?)");
            statement.setString(1, name);
            statement.setString(2, city);
            statement.setString(3, industryType);
            statement.executeUpdate();
            return new Customer(name, city, industryType);
        } finally {
            connection.close();
        }
    }

    public ArrayList<Customer> read() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/postgres?currentSchema=sales_system", "postgres", "password");
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Customer");
            ResultSet resultSet = statement.executeQuery();
            ArrayList<Customer> customers = new ArrayList<>();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String city = resultSet.getString("city");
                String industryType = resultSet.getString("industryType");
                Customer customer = new Customer(name, city, industryType);
                customers.add(customer);
            }
            return customers;
        } finally {
            connection.close();
        }
    }

    public Customer read(String name) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/postgres?currentSchema=sales_system", "postgres", "password");
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Customer WHERE Name = ?");
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String city = resultSet.getString("city");
                String industryType = resultSet.getString("industryType");
                return new Customer(name, city, industryType);
            } else {
                return null;
            }
        } finally {
            connection.close();
        }
    }

    public void update(Customer customer) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/postgres?currentSchema=sales_system", "postgres", "password");
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE Customer SET city=?, industryType = ? WHERE name = ?");
            statement.setString(1, customer.getCity());
            statement.setString(2, customer.getIndustryType());
            statement.setString(3, customer.getName());
            statement.executeUpdate();
        } finally {
            connection.close();
        }
    }

    public void delete(Customer customer) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/postgres?currentSchema=sales_system", "postgres", "password");
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM Customer WHERE name = ?");
            statement.setString(1, customer.getName());
            statement.executeUpdate();
        } finally {
            connection.close();
        }
    }
}
