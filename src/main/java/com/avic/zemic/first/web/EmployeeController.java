package com.avic.zemic.first.web;

import com.avic.zemic.first.model.Employee;
import com.avic.zemic.first.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    private Employee employee = new Employee();

    @GetMapping("/findListEmployee")
    public List<Employee> findListEmploye() {
        List<Employee> employees = this.employeeService.findAllEmployee();
        return employees;
    }

    @GetMapping(value = "/getEmployee")
    public Employee getEmployee() {
        employee.setName("苏驰啊实打实");
        employee.setAge(45);
        employee.setBirthday(new Date());
        return employee;
    }

    @PostMapping("/setEmployee")
    public void setEmployee(Employee command) {
        employee = command;
    }

    @PutMapping(value = "/setEmployeeName")
    public void  setEmployeeName(String name) {
        employee.setName(name);
    }


}
