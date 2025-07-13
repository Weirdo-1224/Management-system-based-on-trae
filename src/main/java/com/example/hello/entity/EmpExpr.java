package com.example.hello.entity;

import lombok.Data;
import java.time.LocalDate;

@Data
/**
 * 员工工作经历实体类
 */
public class EmpExpr {
    /**
     * 经历记录ID
     */
    private Integer id;
    /**
     * 员工ID
     */
    private Integer empId;
    /**
     * 公司名称
     */
    private String company;
    /**
     * 职位名称
     */
    private String position;
    /**
     * 开始日期
     */
    private LocalDate startDate;
    /**
     * 结束日期
     */
    private LocalDate endDate;
}