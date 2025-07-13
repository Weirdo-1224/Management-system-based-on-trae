package com.example.hello.entity;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class Emp {
    /**
     * 员工ID
     */
    private Integer id;
    /**
     * 员工用户名
     */
    private String username;
    /**
     * 员工密码
     */
    private String password;
    /**
     * 员工姓名
     */
    private String name;
    /**
     * 员工性别，使用数字表示
     */
    private Integer gender;
    /**
     * 员工联系电话
     */
    private String phone;
    /**
     * 员工职位，使用数字表示
     */
    private Integer position;
    /**
     * 员工薪资
     */
    private Integer salary;
    /**
     * 员工头像图片路径
     */
    private String image;
    /**
     * 员工入职日期
     */
    private LocalDate hireDate;
    /**
     * 所属部门ID
     */
    private Integer deptId;
    /**
     * 所属部门名称
     */
    private String deptName;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
    /**
     * 员工经历列表
     */
    private List<EmpExpr> exprList;
}