package com.mapper;

import java.util.List;


import org.springframework.stereotype.Service;

import com.po.*;


@Service("IEmpMapper")
public interface IEmpMapper {
    public int save(Emp emp);
    public int update(Emp emp);
    public Emp findById(Integer eid);
    public int delById(Integer eid);
    public List<Emp> findAll(PageBean pb);
    public int findMaxRows();
    public int findMaxeid();
    
   
}
