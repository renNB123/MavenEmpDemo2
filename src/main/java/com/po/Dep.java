package com.po;

import java.io.Serializable;

/**
*@author ����:�Ώ�ع
*
*
*@date ����ʱ��: 2023��4��13������5:42:58
*/
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