package com.project.L41.service.employeeService;

import com.project.L41.model.employeeModel.Employee;
import com.project.L41.repository.employeeRepository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Component
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public void addEmployee( Employee employee) {
        System.out.println("create an Employee");
         try{
             employeeRepository.createEmployee(employee);
         } catch (SQLException e){
             e.printStackTrace();
         }
    }

    @Override
    public List<Employee> getAllEmployees() {
        System.out.println("get all employee");
        List<Employee> employeeList = new ArrayList<>();
        try {
            employeeList = employeeRepository.loadAllEmployees();
        } catch (SQLException e ){
            e.printStackTrace();
        }

        return employeeList;
    }

    @Override
    public Employee getEmployeeByID(Long id) {
        System.out.println("get employee by id");
        Employee employee = null;
        try {
            employee = employeeRepository.findEmployeeByID(id);
        } catch ( SQLException e ){
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public List<Employee> findEmployeeByName(String name) {
        System.out.println("find employee bu name");
        List<Employee> employees = new ArrayList<>();
        Employee employee = null;
        try {
            employees = employeeRepository.findEmployeeByName(name);

        } catch ( SQLException e ){
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public void deleteEmployeeByID(long id) {
        System.out.println("delete employee by id");
        try {
            employeeRepository.deleteEmployeeByID(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateEmployee(Employee employee) {
        System.out.println("update employee");
        try {
            employeeRepository.updateEmployee(employee);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
