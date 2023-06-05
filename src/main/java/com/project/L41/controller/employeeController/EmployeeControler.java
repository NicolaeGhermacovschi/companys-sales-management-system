package com.project.L41.controller.employeeController;

import com.project.L41.model.employeeModel.Employee;
import com.project.L41.service.employeeService.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeControler {
    @Autowired
    EmployeeService employeeService;
    @PostMapping("/employee/add")
    public void createEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
    }

    @GetMapping("/employee/all")
    List<Employee> getAllEmployee(){
        return employeeService.getAllEmployees();
    }
    @GetMapping("/employee/id/{id}")
    Employee getEmployeeByID(@PathVariable long id ){
        return employeeService.getEmployeeByID(id);
    }
    @GetMapping("/employee/name/{name}")
    List<Employee> getEmployeeByName(@PathVariable String name){
        return employeeService.findEmployeeByName(name);
    }
    @DeleteMapping("/employee/id/{id}")
    void deleteEmployeeByID(@PathVariable long id){
        employeeService.deleteEmployeeByID(id);
    }
    @PutMapping("/employee/update")
    void updateEmployee(@RequestBody Employee employee) {
        employeeService.updateEmployee(employee);
    }
}
