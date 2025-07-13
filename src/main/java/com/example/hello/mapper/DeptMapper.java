package com.example.hello.mapper;

import com.example.hello.entity.Dept;
import java.util.List;

public interface DeptMapper {
    // 查询所有部门
    List<Dept> findAll();
    
    // 根据ID查询部门
    Dept findById(Integer id);
    
    // 添加部门
    int insert(Dept dept);
    
    // 更新部门
    int update(Dept dept);
    
    // 删除部门
    int deleteById(Integer id);
}