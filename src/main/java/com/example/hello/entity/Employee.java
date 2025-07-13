package com.example.hello.entity;

import lombok.Data;

/**
 * 员工实体类
 */
@Data
public class Employee {
    private Integer id;
    private String username;
    private String password;
    private String name;
    /**
     * 员工联系电话
     */
    private String phone;
    // Lombok的@Data注解会自动生成以下内容：
    // 1. 所有字段的getter和setter方法
    // 2. toString()方法
    // 3. equals()和hashCode()方法
    // 4. 无参构造方法
}