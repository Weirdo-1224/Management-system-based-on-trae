package com.example.hello.service;

import com.example.hello.entity.Emp;
import com.github.pagehelper.PageInfo;
import java.util.List;

public interface EmpService {
    /**
     * 分页查询员工信息
     * @param page 页码
     * @param pageSize 每页数量
     * @param name 员工姓名
     * @param gender 员工性别
     * @param begin 开始时间
     * @param end 结束时间
     * @return 分页后的员工信息
     */
    PageInfo<Emp> selectByPage(Integer page, Integer pageSize, String name, Integer gender, String begin, String end);

    /**
     * 根据员工ID列表删除员工信息
     * @param ids 员工ID列表
     * @return 删除成功的数量
     */
    int deleteByIds(List<Integer> ids);

    /**
     * 添加员工信息
     * @param emp 员工实体对象
     * @return 添加成功返回1，失败返回0
     */
    int addEmp(Emp emp);

    /**
     * 根据员工ID查询员工信息
     * @param id 员工ID
     * @return 员工实体对象
     */
    Emp selectById(Integer id);

    /**
     * 更新员工信息
     * @param emp 员工实体对象
     * @return 更新成功返回1，失败返回0
     */
    int updateEmp(Emp emp);

    /**
     * 查询所有员工信息
     * @return 所有员工信息列表
     */
    List<Emp> selectAll();
}