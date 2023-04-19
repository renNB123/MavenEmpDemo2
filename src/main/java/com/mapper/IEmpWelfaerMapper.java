package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.po.EmpWelFare;
import com.po.Welfare;

/**
*@author ����:�Ώ�ع
*
*
*@date ����ʱ��: 2023��4��13������6:43:13
*/
@Service("IEmpWelfaerMapper")
public interface IEmpWelfaerMapper {
	public int save(EmpWelFare ewf);
	public int delByEid(Integer eid);
	public List<Welfare> finByEid(Integer eid);
	

	
	
}
