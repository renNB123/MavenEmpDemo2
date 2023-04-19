package com.util;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mapper.*;

/**
*@author 作者:任徳毓
*
*
*@date 创建时间: 2023年4月14日上午12:17:38
*/


@Service("MapperUtil")
public class MapperUtil {
@Resource(name="IDepMapper")
private IDepMapper depmapper;
@Resource(name="IEmpMapper")
private IEmpMapper empmapper;
@Resource(name="IWelfareMapper")
private IWelfareMapper wfmapper;
@Resource(name="IEmpWelfaerMapper")
private IEmpWelfaerMapper empwfmapper;
@Resource(name="ISalaryMapper")
private ISalaryMapper salarymapper;
public IDepMapper getDepmapper() {
	return depmapper;
}
public void setDepmapper(IDepMapper depmapper) {
	this.depmapper = depmapper;
}
public IEmpMapper getEmpmapper() {
	return empmapper;
}
public void setEmpmapper(IEmpMapper empmapper) {
	this.empmapper = empmapper;
}
public IWelfareMapper getWfmapper() {
	return wfmapper;
}
public void setWfmapper(IWelfareMapper wfmapper) {
	this.wfmapper = wfmapper;
}
public IEmpWelfaerMapper getEmpwfmapper() {
	return empwfmapper;
}
public void setEmpwfmapper(IEmpWelfaerMapper empwfmapper) {
	this.empwfmapper = empwfmapper;
}
public ISalaryMapper getSalarymapper() {
	return salarymapper;
}
public void setSalarymapper(ISalaryMapper salarymapper) {
	this.salarymapper = salarymapper;
}


	
	
}
