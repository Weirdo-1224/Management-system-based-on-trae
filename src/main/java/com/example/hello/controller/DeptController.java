package com.example.hello.controller;

import com.example.hello.common.Result;
import com.example.hello.entity.Dept;
import com.example.hello.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/depts")
public class DeptController {

    @Autowired
    private DeptService deptService;

    // 查询所有部门
    @GetMapping
    public Result<List<Dept>> list() {
        return Result.success(deptService.list());
    }

    // 根据ID查询部门
    @GetMapping("/{id}")
    public Result<Dept> getById(@PathVariable Integer id) {
        return Result.success(deptService.getById(id));
    }

    // 添加部门
    @PostMapping
    public Result<Void> add(@RequestBody Dept dept) {
        deptService.add(dept);
        return Result.success();
    }

    // 更新部门
    @PutMapping
    public Result<Void> update(@RequestBody Dept dept) {
        deptService.update(dept);
        return Result.success();
    }

    //删除部门
    @DeleteMapping("/{id}")
    public Result<Void> delete(@PathVariable Integer id) {
        deptService.delete(id);
        return Result.success();
    }
}