package com.avic.zemic.first.service.impl;

import com.avic.zemic.first.model.Employee;
import com.avic.zemic.first.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    private static AtomicLong counter = new AtomicLong();
    private final ConcurrentMap<Long, Employee> employeeConcurrentHashMap = new ConcurrentHashMap<>();
    @Override
    public List<Employee> findAllEmployee() {
        List<Employee> employees = new ArrayList<>(this.employeeConcurrentHashMap.values());
        return employees;
    }

    @Override
    public Employee findEmployeeByName(String name) {
        return null;
    }

    @Override
    public Employee insertEmployee(Employee employee) {
        Long id = counter.incrementAndGet();
        this.employeeConcurrentHashMap.put(id, employee);
        return employee;
    }
}
