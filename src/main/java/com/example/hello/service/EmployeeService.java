package com.example.hello.service;

import com.example.hello.entity.Employee;

public interface EmployeeService {
    /**
     * 根据用户名查询员工信息
     * @param username 用户名
     * @return 员工对象
     */
    Employee getEmpByUsername(String username);
}