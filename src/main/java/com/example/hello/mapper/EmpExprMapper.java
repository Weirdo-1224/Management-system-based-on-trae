package com.example.hello.mapper;

import com.example.hello.entity.EmpExpr;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface EmpExprMapper {
    // 批量插入经历
    int batchInsert(@Param("exprList") List<EmpExpr> exprList);
    // 根据员工ID删除经历
    int deleteByEmpId(Integer empId);
    // 根据员工ID查询经历
    List<EmpExpr> selectByEmpId(Integer empId);
}