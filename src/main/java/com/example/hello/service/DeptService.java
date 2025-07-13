package com.example.hello.service;

import com.example.hello.entity.Dept;
import java.util.List;

public interface DeptService {
    List<Dept> list();
    Dept getById(Integer id);
    void add(Dept dept);
    void update(Dept dept);
    void delete(Integer id);
}