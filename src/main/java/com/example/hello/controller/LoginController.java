package com.example.hello.controller;

import com.example.hello.dto.LoginRequest;
import com.example.hello.dto.Result;
import com.example.hello.entity.Employee;
import com.example.hello.service.EmployeeService;
import com.example.hello.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private JwtUtils jwtUtils;

    /**
     * 员工登录接口
     * @param loginRequest 登录请求参数
     * @return 包含 JWT 令牌的登录结果
     */
    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<Map<String, Object>> login(@Validated @RequestBody LoginRequest loginRequest) {
        // 通过用户名查询员工信息
        Employee employee = employeeService.getEmpByUsername(loginRequest.getUsername());
        // 验证员工是否存在以及密码是否正确
        if (employee == null || !employee.getPassword().equals(loginRequest.getPassword())) {
            return Result.error("用户名或密码错误");
        }
        // 生成 JWT 令牌
        String token = jwtUtils.generateToken(employee.getId(), employee.getUsername());
        // 构建响应数据
        Map<String, Object> data = new HashMap<>();
        data.put("id", employee.getId());
        data.put("username", employee.getUsername());
        data.put("name", employee.getName());
        data.put("token", token);
        return Result.success(data);
    }
}