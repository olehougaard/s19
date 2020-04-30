package dk.via.salessystem.db;

import dk.via.salessystem.Customer;
import org.postgresql.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    static {
        try {
            DriverManager.registerDriver(new Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FunctionalInterface
    public interface SqlConsumer<T> {
        void accept(T t) throws SQLException;
    }

    @FunctionalInterface
    public interface SqlFunction<T, U> {
        U apply(T t) throws SQLException;
    }

    private void executeUpdate(String sql, SqlConsumer<PreparedStatement> consumer) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/postgres?currentSchema=sales_system", "postgres", "password");
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            consumer.accept(statement);
            statement.executeUpdate();
        } finally {
            connection.close();
        }
    }

    private<U> U executeQuery(String sql, SqlConsumer<PreparedStatement> prepare, SqlFunction<ResultSet, U> generator) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/postgres?currentSchema=sales_system", "postgres", "password");
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            prepare.accept(statement);
            ResultSet resultSet = statement.executeQuery();
            return generator.apply(resultSet);
        } finally {
            connection.close();
        }
    }

    private<U> U read(String sql, SqlConsumer<PreparedStatement> prepare, SqlFunction<ResultSet, U> factory) throws SQLException {
        return executeQuery(sql, prepare, resultSet -> {
            if (resultSet.next())
                return factory.apply(resultSet);
            else
                return null;
        });
    }

    private<U> List<U> map(String sql, SqlConsumer<PreparedStatement> prepare, SqlFunction<ResultSet, U> factory) throws SQLException {
        return executeQuery(sql, prepare, resultSet -> {
            ArrayList<U> result = new ArrayList<>();
            while (resultSet.next())
                result.add(factory.apply(resultSet));
            return result;
        });
    }

    public Customer create(String name, String city, String industryType) throws SQLException {
        executeUpdate("INSERT INTO Customer VALUES(?, ?, ?)", statement -> {
            statement.setString(1, name);
            statement.setString(2, city);
            statement.setString(3, industryType);
        });
        return new Customer(name, city, industryType);
    }

    private Customer createCustomer(ResultSet resultSet) throws SQLException {
        String name = resultSet.getString("name");
        String city = resultSet.getString("city");
        String industryType = resultSet.getString("industryType");
        return new Customer(name, city, industryType);
    }

    public List<Customer> read() throws SQLException {
        return map("SELECT * FROM Customer", s -> {}, resultSet -> createCustomer(resultSet));
    }

    public Customer read(String name) throws SQLException {
        return read("SELECT * FROM Customer WHERE Name = ?",
            statement -> statement.setString(1, name),
            resultSet -> createCustomer(resultSet));
    }

    public void update(Customer customer) throws SQLException {
        executeUpdate("UPDATE Customer SET city=?, industryType = ? WHERE name = ?", statement -> {
            statement.setString(1, customer.getCity());
            statement.setString(2, customer.getIndustryType());
            statement.setString(3, customer.getName());
        });
    }

    public void delete(Customer customer) throws SQLException {
        executeUpdate("DELETE FROM Customer WHERE name = ?", statement -> {
            statement.setString(1, customer.getName());
        });
    }
}
