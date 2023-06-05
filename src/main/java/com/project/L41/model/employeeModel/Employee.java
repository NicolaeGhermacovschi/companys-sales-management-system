package com.project.L41.model.employeeModel;

public class Employee {
    private long id;
    private String firstName;
    private String lastName;
    private EmployeeFunction employeeFunction;
    private double salary;
    private long idStore;

    public Employee() {
    }

    public Employee(long id, String firstName, String lastName, EmployeeFunction employeeFunction, double salary, long idStore) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeFunction = employeeFunction;
        this.salary = salary;
        this.idStore = idStore;
    }

    public Employee(String firstName, String lastName, EmployeeFunction employeeFunction, double salary,long idStore) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeFunction = employeeFunction;
        this.salary = salary;
        this.idStore = idStore;
    }

    public long getIdStore() {
        return idStore;
    }

    public void setIdStore(long idStore) {
        this.idStore = idStore;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public EmployeeFunction getEmployeeFunction() {
        return employeeFunction;
    }

    public void setEmployeeFunction(EmployeeFunction employeeFunction) {
        this.employeeFunction = employeeFunction;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", employeeFunction=" + employeeFunction +
                '}';
    }
}
