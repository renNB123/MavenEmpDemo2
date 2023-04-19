package com.util;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.service.*;

/**
*@author 作者:任徳毓
*
*
*@date 创建时间: 2023年4月14日上午12:17:38
*/


@Service("ServiceUtil")
public class ServiceUtil {
@Resource(name="DepService")
private IDepService depservice;
@Resource(name="EmpService")
private IEmpService empservice;
@Resource(name="WelfareService")
private IWelfareService wfservice;
public IDepService getDepservice() {
	return depservice;
}
public void setDepservice(IDepService depservice) {
	this.depservice = depservice;
}
public IEmpService getEmpservice() {
	return empservice;
}
public void setEmpservice(IEmpService empservice) {
	this.empservice = empservice;
}
public IWelfareService getWfservice() {
	return wfservice;
}
public void setWfservice(IWelfareService wfservice) {
	this.wfservice = wfservice;
}

	
	
}
