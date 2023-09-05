package com.itheima.service.impl;

import com.itheima.mapper.DeptMapper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Dept;
import com.itheima.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper emptMapper;
    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }
    @Transactional()//spring 进行事务管理
    @Override
    public void delete(Integer id) {

        deptMapper.deleteById(id);//根据id删除部门的数据
        //
        emptMapper.deleteByDeptId(id);//根据部门的id来删除部门下员工的数据
    }

    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());

        deptMapper.insert(dept);
    }
}
