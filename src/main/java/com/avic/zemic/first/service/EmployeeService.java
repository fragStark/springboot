package com.avic.zemic.first.service;

import com.avic.zemic.first.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAllEmployee();
    Employee findEmployeeByName(String name);
    Employee insertEmployee(Employee employee);
}
