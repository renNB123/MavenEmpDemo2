package com.po;

import java.io.Serializable;

/**
*@author ����:�Ώ�ع
*
*
*@date ����ʱ��: 2023��4��13������5:54:03
*/
public class Welfare implements Serializable{
	private Integer wid;
	private String wname;
	@Override
	public String toString() {
		return "Welfare [wid=" + wid + ", wname=" + wname + "]";
	}
	public Integer getWid() {
		return wid;
	}
	public void setWid(Integer wid) {
		this.wid = wid;
	}
	public String getWname() {
		return wname;
	}
	public void setWname(String wname) {
		this.wname = wname;
	}
	public Welfare(Integer wid, String wname) {
		super();
		this.wid = wid;
		this.wname = wname;
	}
	public Welfare() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Welfare(String wname) {
		super();
		this.wname = wname;
	}
	
}
