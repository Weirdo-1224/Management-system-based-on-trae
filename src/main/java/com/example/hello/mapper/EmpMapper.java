package com.example.hello.mapper;

import com.example.hello.entity.Emp;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

public interface EmpMapper {
    // 分页条件查询
    List<Emp> selectByPage(Map<String, Object> params);
    // 批量删除
    int deleteByIds(@Param("ids") List<Integer> ids);
    // 添加员工
    int insert(Emp emp);
    // 根据ID查询
    Emp selectById(Integer id);
    // 更新员工
    int update(Emp emp);
    // 查询全部
    List<Emp> selectAll();
}