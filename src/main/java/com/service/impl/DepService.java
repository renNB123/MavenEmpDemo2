package com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.po.Dep;
import com.service.IDepService;
import com.util.MapperUtil;

/**
*@author ����:�Ώ�ع
*
*
*@date ����ʱ��: 2023��4��14������1:01:20
*/
@Service("DepService")
@Transactional
public class DepService implements IDepService {
	@Resource(name="MapperUtil")
	private MapperUtil mapperservice;
	
	

	public MapperUtil getMapperservice() {
		return mapperservice;
	}



	public void setMapperservice(MapperUtil mapperservice) {
		this.mapperservice = mapperservice;
	}



	
	public List<Dep> findAll() {
	
		return mapperservice.getDepmapper().findAll();
	}

}
