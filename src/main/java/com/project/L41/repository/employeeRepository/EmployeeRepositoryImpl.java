package com.project.L41.repository.employeeRepository;

import com.project.L41.model.employeeModel.Employee;
import com.project.L41.model.employeeModel.EmployeeFunction;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class EmployeeRepositoryImpl implements EmployeeRepository {
    private static String URL = "jdbc:postgresql://localhost:5432/L41";
    private static String user = "postgres";
    private static String password = "admin";

    @Override
    public void createEmployee(Employee employee) throws SQLException {
        try (Connection conn = DriverManager.getConnection(URL, user, password)) {
            PreparedStatement preparedStatement = conn.prepareStatement("" +
                    "INSERT INTO employees (first_name, last_name, employee_function, salary, id_store) VALUES (?, ?, ?, ?,?);");
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, String.valueOf(employee.getEmployeeFunction()));
            preparedStatement.setDouble(4, employee.getSalary());
            preparedStatement.setLong(5, employee.getIdStore());

            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Employee> loadAllEmployees() throws SQLException {
        List<Employee> employeeList;

        try (Connection conn = DriverManager.getConnection(URL, user, password)) {
            PreparedStatement preparedStatement = conn.prepareStatement("" +
                    "SELECT * FROM employees;");
            ResultSet resultSet = preparedStatement.executeQuery();

            employeeList = new ArrayList<>();

            while (resultSet.next()) {
                Long id = resultSet.getLong(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                EmployeeFunction employeeFunction = EmployeeFunction.valueOf(resultSet.getString(4));
                double salary = resultSet.getDouble(5);
                Long idStore = resultSet.getLong(6);

                Employee empl = new Employee(id, firstName, lastName, employeeFunction, salary, idStore);
                employeeList.add(empl);
            }

            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return employeeList;
    }

    @Override
    public Employee findEmployeeByID(long id) throws SQLException {
        Employee empl = null;
        try (Connection conn = DriverManager.getConnection(URL, user, password)) {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM employees WHERE id = ?;");
            preparedStatement.setLong(1, id);


            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Long idDB = resultSet.getLong(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                EmployeeFunction employeeFunction = EmployeeFunction.valueOf(resultSet.getString(4));
                double salary = resultSet.getDouble(5);
                Long idStore = resultSet.getLong(6);

                empl = new Employee(idDB, firstName, lastName, employeeFunction, salary, idStore);

            }

            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return empl;
    }

    @Override
    public List<Employee> findEmployeeByName(String name) throws SQLException {
        List<Employee> employeeArrays = new ArrayList<>();
        Employee empl = null;
        try (Connection conn = DriverManager.getConnection(URL, user, password)) {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM employees WHERE first_name = ?;");
            preparedStatement.setString(1, name);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Long idDB = resultSet.getLong(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                EmployeeFunction employeeFunction = EmployeeFunction.valueOf(resultSet.getString(4));
                double salary = resultSet.getDouble(5);
                Long idStore = resultSet.getLong(6);

                empl = new Employee(idDB, firstName, lastName, employeeFunction, salary, idStore);
                employeeArrays.add(empl);

            }

            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employeeArrays;
    }

    @Override
    public void deleteEmployeeByID(long id) {
        try (Connection conn = DriverManager.getConnection(URL, user, password)) {
            PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM employees WHERE id = ?;");
            preparedStatement.setLong(1, id);

            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateEmployee(Employee employee) {

        try (Connection conn = DriverManager.getConnection(URL, user, password)) {
            PreparedStatement preparedStatement =
                    conn.prepareStatement("UPDATE employees SET first_name = ?, last_name = ?, employee_Function = ?, salary = ?, id_store = ? WHERE id = ?");
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, String.valueOf(employee.getEmployeeFunction()));
            preparedStatement.setDouble(4, employee.getSalary());
            preparedStatement.setLong(5, employee.getIdStore());
            preparedStatement.setLong(6, employee.getId());

            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
