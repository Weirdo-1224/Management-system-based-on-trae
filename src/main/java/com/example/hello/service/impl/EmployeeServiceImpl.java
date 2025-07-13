package com.example.hello.service.impl;

import com.example.hello.entity.Employee;
import com.example.hello.mapper.EmployeeMapper;
import com.example.hello.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public Employee getEmpByUsername(String username) {
        return employeeMapper.selectByUsername(username);
    }
}