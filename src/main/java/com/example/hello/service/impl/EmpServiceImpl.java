package com.example.hello.service.impl;

import com.example.hello.entity.Emp;
import com.example.hello.entity.EmpExpr;
import com.example.hello.mapper.EmpExprMapper;
import com.example.hello.mapper.EmpMapper;
import com.example.hello.service.EmpService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private EmpExprMapper empExprMapper;

    @Override
    public PageInfo<Emp> selectByPage(Integer page, Integer pageSize, String name, Integer gender, String begin, String end) {
        PageHelper.startPage(page, pageSize);
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        params.put("gender", gender);
        params.put("begin", begin);
        params.put("end", end);
        List<Emp> emps = empMapper.selectByPage(params);
        return new PageInfo<>(emps);
    }

    @Override
    @Transactional
    public int deleteByIds(List<Integer> ids) {
        // 删除员工关联的经历
        ids.forEach(id -> empExprMapper.deleteByEmpId(id));
        // 删除员工
        return empMapper.deleteByIds(ids);
    }

    @Override
    @Transactional
    public int addEmp(Emp emp) {
        // 设置默认密码
        emp.setPassword(emp.getPassword() == null ? "123456" : emp.getPassword());
        // 插入员工
        int rows = empMapper.insert(emp);
        // 插入经历
        if (emp.getExprList() != null && !emp.getExprList().isEmpty()) {
            emp.getExprList().forEach(expr -> expr.setEmpId(emp.getId()));
            empExprMapper.batchInsert(emp.getExprList());
        }
        return rows;
    }

    @Override
    public Emp selectById(Integer id) {
        Emp emp = empMapper.selectById(id);
        if (emp != null) {
            List<EmpExpr> exprList = empExprMapper.selectByEmpId(id);
            emp.setExprList(exprList);
        }
        return emp;
    }

    @Override
    @Transactional
    public int updateEmp(Emp emp) {
        // 更新员工信息
        int rows = empMapper.update(emp);
        // 先删除原有经历
        empExprMapper.deleteByEmpId(emp.getId());
        // 再插入新的经历
        if (emp.getExprList() != null && !emp.getExprList().isEmpty()) {
            emp.getExprList().forEach(expr -> expr.setEmpId(emp.getId()));
            empExprMapper.batchInsert(emp.getExprList());
        }
        return rows;
    }

    @Override
    public List<Emp> selectAll() {
        return empMapper.selectAll();
    }
}