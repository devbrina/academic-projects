package DAO;

/**
 *
 * @author sabrina
 */
public class Employee {
    private int employeeNumber;
    private String name;
    private double salary;
    private char gender;
    private int departmentNumber;
    private int supervisorNumber;

    // Getters and Setters
    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getDepartmentNumber() {
        return departmentNumber;
    }

    public void setDepartmentNumber(int departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    public int getSupervisorNumber() {
        return supervisorNumber;
    }

    public void setSupervisorNumber(int supervisorNumber) {
        this.supervisorNumber = supervisorNumber;
    }

    @Override
    public String toString() {
        return "Employee [employeeNumber=" + employeeNumber + ", name=" + name + ", salary=" + salary + ", gender=" + gender
                + ", departmentNumber=" + departmentNumber + ", supervisorNumber=" + supervisorNumber + "]";
    }
}
