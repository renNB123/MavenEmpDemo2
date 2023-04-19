package com.mapper;



import org.springframework.stereotype.Service;

import com.po.Salary;

/**
*@author 作者:任徳毓
*
*
*@date 创建时间: 2023年4月13日下午6:43:13
*/
@Service("ISalaryMapper")
public interface ISalaryMapper {
	//保存薪资
	public int save(Salary sa);
	//删除薪资
	public int delByEid(Integer eid);
	
	 public int update(Salary sa);
	 
	 public Salary findById(Integer eid);
	

	
	
}
