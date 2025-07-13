package com.example.hello.controller;

import com.example.hello.common.Result;
import com.example.hello.entity.Emp;
import com.example.hello.service.EmpService;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    private EmpService empService;

    // 员工列表查询
    @GetMapping
    public Result<PageInfo<Emp>> selectByPage(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer pageSize,
            String name,
            Integer gender,
            String begin,
            String end) {
        PageInfo<Emp> pageInfo = empService.selectByPage(page, pageSize, name, gender, begin, end);
        return Result.success(pageInfo);
    }

    // 删除员工
    @DeleteMapping
    public Result<Void> deleteByIds(@RequestParam String ids) {
        List<Integer> idList = Arrays.stream(ids.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        empService.deleteByIds(idList);
        return Result.success();
    }

    // 添加员工
    @PostMapping
    public Result<Void> addEmp(@RequestBody Emp emp) {
        empService.addEmp(emp);
        return Result.success();
    }

    // 根据ID查询
    @GetMapping("/{id}")
    public Result<Emp> selectById(@PathVariable Integer id) {
        Emp emp = empService.selectById(id);
        return Result.success(emp);
    }

    // 修改员工
    @PutMapping
    public Result<Void> updateEmp(@RequestBody Emp emp) {
        empService.updateEmp(emp);
        return Result.success();
    }

    // 查询全部员工
    @GetMapping("/list")
    public Result<List<Emp>> selectAll() {
        List<Emp> emps = empService.selectAll();
        return Result.success(emps);
    }
}