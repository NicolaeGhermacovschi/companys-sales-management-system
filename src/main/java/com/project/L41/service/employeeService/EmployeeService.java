package com.project.L41.service.employeeService;

import com.project.L41.model.employeeModel.Employee;

import java.util.List;

public interface EmployeeService {

    void addEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeByID(Long id);

    List<Employee> findEmployeeByName(String name);
    void deleteEmployeeByID(long id);
    void updateEmployee(Employee employee);


}
