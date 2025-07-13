package com.example.hello.mapper;

import com.example.hello.entity.Employee;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeMapper {
    /**
     * Query employee by username
     * @param username username
     * @return employee object
     */
    Employee selectByUsername(@Param("username") String username);
}