package dk.via.salessystem.db;

import dk.via.salessystem.Salesperson;
import org.postgresql.Driver;

import java.sql.*;
import java.util.ArrayList;

public class JDBCtest {
    public static void main(String[] args) throws SQLException {
        DriverManager.registerDriver(new Driver());
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/postgres?currentSchema=sales_system", "postgres", "password");
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Salesperson");
            ResultSet rs = statement.executeQuery();
            ArrayList<Salesperson> persons = new ArrayList<>();
            while (rs.next()) {
                String name = rs.getString("name");
                int percentOfQuota = rs.getInt("percentOfQuota");
                int salary = rs.getInt("salary");
                persons.add(new Salesperson(name, percentOfQuota, salary));
            }
            System.out.println(persons);
            int salary = 150000;
            String name = "Baker";
            statement = connection.prepareStatement("UPDATE Salesperson SET salary = ? WHERE Name = ?");
            statement.setInt(1, salary);
            statement.setString(2, name);
            statement.executeUpdate();
        } finally {
            connection.close();
        }
    }
}
