package com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.po.Welfare;
import com.service.IWelfareService;
import com.util.MapperUtil;

/**
*@author ����:�Ώ�ع
*
*
*@date ����ʱ��: 2023��4��14������1:03:46
*/
@Service("WelfareService")
@Transactional
public class WelfareService implements IWelfareService {
	@Resource(name="MapperUtil")
	private MapperUtil mapperservice;
	
	

	public MapperUtil getMapperservice() {
		return mapperservice;
	}



	public void setMapperservice(MapperUtil mapperservice) {
		this.mapperservice = mapperservice;
	}



	
	public List<Welfare> findAll() {
		// TODO Auto-generated method stub
		return mapperservice.getWfmapper().findAll();
	}

}
