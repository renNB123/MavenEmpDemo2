package com.po;

import java.io.Serializable;

/**
*@author 作者:任徳毓
*
*
*@date 创建时间: 2023年4月13日下午5:42:58
*/
//tianjiagesha
public class Dep implements Serializable{
private Integer depid;
private String depname;
@Override
public String toString() {
	return "Dep [depid=" + depid + ", depname=" + depname + "]";
}
public Integer getDepid() {
	return depid;
}
public void setDepid(Integer depid) {
	this.depid = depid;
}
public String getDepname() {
	return depname;
}
public void setDepname(String depname) {
	this.depname = depname;
}
public Dep(Integer depid, String depname) {
	super();
	this.depid = depid;
	this.depname = depname;
}
public Dep() {
	super();
	// TODO Auto-generated constructor stub
}

	
	
}
