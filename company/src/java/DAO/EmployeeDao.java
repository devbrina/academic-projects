package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sabrina
 */

// Everything related to the 'Funcionario' table in the database will be handled through this class
public class EmployeeDao {
    private Connection connection;

    public EmployeeDao() {    // Constructor responsible for connecting to the database
        this.connection = new ConnectionFactory().getConnection();
    }

    public void add(Employee employee) {
        // Create the 'employee' table if it doesn't exist
        String createTableSQL = "CREATE TABLE IF NOT EXISTS employee ("
                + "employeeNumber BIGINT NOT NULL,"
                + "name VARCHAR(255) NOT NULL,"
                + "salary DECIMAL(6,1),"
                + "gender CHAR(1),"
                + "departmentNumber INTEGER,"
                + "supervisorNumber BIGINT,"
                + "PRIMARY KEY (employeeNumber)"
                + ")";

        String insertSQL = "INSERT INTO employee (employeeNumber, name, salary, gender, departmentNumber, supervisorNumber) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement stmt = this.connection.prepareStatement(insertSQL);
            stmt.setLong(1, employee.getEmployeeNumber());
            stmt.setString(2, employee.getName());
            stmt.setDouble(3, employee.getSalary());
            stmt.setString(4, String.valueOf(employee.getGender()));
            stmt.setInt(5, employee.getDepartmentNumber());
            stmt.setLong(6, employee.getSupervisorNumber());

            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }

    public ArrayList<Employee> getList() {
        String sql = "SELECT * FROM employee";
        ArrayList<Employee> employees = new ArrayList<Employee>();

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(); // Retrieve all records

            while (rs.next()) { // Valid position
                Employee employee = new Employee();
                employee.setEmployeeNumber(rs.getInt("employeeNumber"));
                employee.setName(rs.getString("name"));
                employee.setSalary(rs.getDouble("salary"));
                employee.setGender(rs.getString("gender").charAt(0));
                employee.setDepartmentNumber(rs.getInt("departmentNumber"));
                employee.setSupervisorNumber(rs.getInt("supervisorNumber"));

                // Adding the object to the ArrayList
                employees.add(employee);
            }
            rs.close();
            stmt.close();

            connection.commit();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return employees;
    }

    public Employee query(long employeeNumber) {
        String sql = "SELECT * FROM employee WHERE employeeNumber = ?";
        Employee employee = null;

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setLong(1, employeeNumber);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                employee = new Employee();
                employee.setEmployeeNumber(rs.getInt("employeeNumber"));
                employee.setName(rs.getString("name"));
                employee.setSalary(rs.getDouble("salary"));
                employee.setGender(rs.getString("gender").charAt(0));
                employee.setDepartmentNumber(rs.getInt("departmentNumber"));
                employee.setSupervisorNumber(rs.getInt("supervisorNumber"));
            }

            rs.close();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return employee;
    }

    public void update(Employee employee) {
        String updateSQL = "UPDATE employee SET name = ?, salary = ?, gender = ?, departmentNumber = ?, supervisorNumber = ? WHERE employeeNumber = ?";

        try (PreparedStatement stmt = this.connection.prepareStatement(updateSQL)) {
            stmt.setString(1, employee.getName());
            stmt.setDouble(2, employee.getSalary());
            stmt.setString(3, String.valueOf(employee.getGender()));
            stmt.setInt(4, employee.getDepartmentNumber());
            stmt.setLong(5, employee.getSupervisorNumber());
            stmt.setLong(6, employee.getEmployeeNumber());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Error updating employee in the database", ex);
        }
    }

    public void delete(long employeeNumber) {
        String deleteSQL = "DELETE FROM employee WHERE employeeNumber = ?";

        try (PreparedStatement stmt = this.connection.prepareStatement(deleteSQL)) {
            stmt.setLong(1, employeeNumber);

            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Error deleting employee from the database", ex);
        }
    }

    public boolean isSupervisor(long employeeNumber) {
        String sql = "SELECT COUNT(*) FROM employee WHERE supervisorNumber = ?";
        int count = 0;

        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setLong(1, employeeNumber);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
            }

            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException("Error checking if employee is a supervisor", e);
        }

        return count > 0;
    }
}
