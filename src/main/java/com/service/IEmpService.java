package com.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.po.*;
import com.po.PageBean;


public interface IEmpService {
    public boolean save(Emp emp);
    public boolean update(Emp emp);
    public Emp findById(Integer eid);
    public boolean delById(Integer eid);
    public List<Emp> findAll(PageBean pb);
    public int findMaxRows();
    
   
}
