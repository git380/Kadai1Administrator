package E100.E102.dao;

import A100.dao.DAOParam;
import E100.E102.model.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO extends DAOParam {

    public List<Employee> getAllEmployees() {
        List<Employee> employeeList = new ArrayList<>();

        // Connect to the database
        try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
            String sql = "SELECT * FROM employee WHERE emprole != 0";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String empId = resultSet.getString("empid");
                String empFname = resultSet.getString("empfname");
                String empLname = resultSet.getString("emplname");
                Employee employee = new Employee(empId, empFname, empLname);
                employeeList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employeeList;
    }

    public void updateEmployee(String empId, String empFname, String lastName) {
        // Connect to the database
        try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
            String sql = "UPDATE employee SET empfname = ?, emplname = ? WHERE empid = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, empFname);
            statement.setString(2, lastName);
            statement.setString(3, empId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
