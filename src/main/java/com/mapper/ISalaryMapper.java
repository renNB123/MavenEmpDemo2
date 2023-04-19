package com.mapper;



import org.springframework.stereotype.Service;

import com.po.Salary;

/**
*@author ����:�Ώ�ع
*
*
*@date ����ʱ��: 2023��4��13������6:43:13
*/
@Service("ISalaryMapper")
public interface ISalaryMapper {
	//����н��
	public int save(Salary sa);
	//ɾ��н��
	public int delByEid(Integer eid);
	
	 public int update(Salary sa);
	 
	 public Salary findById(Integer eid);
	

	
	
}
