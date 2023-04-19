package com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.po.Emp;
import com.po.EmpWelFare;
import com.po.PageBean;
import com.po.Salary;
import com.po.Welfare;
import com.service.IEmpService;
import com.util.MapperUtil;

/**
*@author 作者:任徳毓
*
*
*@date 创建时间: 2023年4月14日上午1:03:13
*/
@Service("EmpService")
@Transactional
public class EmpService implements IEmpService {
	@Resource(name="MapperUtil")
	private MapperUtil mapperservice;
	
	

	public MapperUtil getMapperservice() {
		return mapperservice;
	}



	public void setMapperservice(MapperUtil mapperservice) {
		this.mapperservice = mapperservice;
	}



	
	public boolean save(Emp emp) {
	int r=mapperservice.getEmpmapper().save(emp);
	if(r>0){
	int meid=mapperservice.getEmpmapper().findMaxeid();
	Salary sa=new Salary(meid,emp.getEmoney());
	int dr=mapperservice.getSalarymapper().save(sa);
	if(dr>0){
		String[] wids=emp.getWids();
		for (int i = 0; i < wids.length; i++) {
			EmpWelFare ewf=new EmpWelFare(meid,Integer.parseInt(wids[i]));
			mapperservice.getEmpwfmapper().save(ewf);
		}
		return true;
		
	}
	
	
	
	return true;
	
	}
	
	
		return false;
	}

	
	public boolean update(Emp emp) {
		
		int r=mapperservice.getEmpmapper().update(emp);
		if(r>0){
		
		Salary sa=new Salary(emp.getEid(),emp.getEmoney());
		int dr=mapperservice.getSalarymapper().update(sa);
		if(dr>0){
			mapperservice.getEmpwfmapper().delByEid(emp.getEid());
			String[] wids=emp.getWids();
			for (int i = 0; i < wids.length; i++) {
				EmpWelFare ewf=new EmpWelFare(emp.getEid(),Integer.parseInt(wids[i]));
				mapperservice.getEmpwfmapper().save(ewf);
			}
			return true;
			
		}
		
		
		
	
		
		}
		
		
			return false;
	}


	public Emp findById(Integer eid) {
		System.out.println("进入service");
		Emp emp=mapperservice.getEmpmapper().findById(eid);
		System.out.println("员工id没问题");
		List<Welfare> lswf=mapperservice.getEmpwfmapper().finByEid(eid);
		System.out.println("福利id没问题");
		if(lswf!=null){
		String[] wids=new String[lswf.size()];
		for (int i = 0; i < lswf.size(); i++) {
			Welfare wf=lswf.get(i);
			wids[i]=wf.getWid().toString();
		
		}
		emp.setWids(wids);
		}
		emp.setLswf(lswf);
		emp.setEmoney(mapperservice.getSalarymapper().findById(eid).getEmoney());
		System.out.println("id没问题");
		return emp;
	}


	public boolean delById(Integer eid) {
		if(mapperservice.getEmpwfmapper().delByEid(eid)>0){
			if(mapperservice.getSalarymapper().delByEid(eid)>0){
				if(mapperservice.getEmpmapper().delById(eid)>0){
					return true;
				}
			}
		 
		}		
		return false;
	}


	public List<Emp> findAll(PageBean pb) {
		
		return mapperservice.getEmpmapper().findAll(pb);
	}




	public int findMaxRows() {
		// TODO Auto-generated method stub
		return mapperservice.getEmpmapper().findMaxRows();
	}


}
