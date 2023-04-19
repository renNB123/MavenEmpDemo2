package com.po;

import java.io.Serializable;

/**
*@author 作者:任徳毓
*
*
*@date 创建时间: 2023年4月13日下午5:46:47
*/
public class EmpWelFare implements Serializable{
	private Integer ewid;
	private Integer eid;
	private Integer wid;
	public Integer getEwid() {
		return ewid;
	}
	public void setEwid(Integer ewid) {
		this.ewid = ewid;
	}
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public Integer getWid() {
		return wid;
	}
	public void setWid(Integer wid) {
		this.wid = wid;
	}
	public EmpWelFare(Integer ewid, Integer eid, Integer wid) {
		super();
		this.ewid = ewid;
		this.eid = eid;
		this.wid = wid;
	}
	public EmpWelFare() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "EmpWelFare [ewid=" + ewid + ", eid=" + eid + ", wid=" + wid + "]";
	}
	public EmpWelFare(Integer eid, Integer wid) {
		super();
		this.eid = eid;
		this.wid = wid;
	}

	
}
