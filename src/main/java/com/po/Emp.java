package com.po;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

/**
*@author 作者:任徳毓
*
*
*@date 创建时间: 2023年4月13日下午5:58:15
*/
public class Emp implements Serializable{
   private Integer eid;
   private String ename;
   private String sex;
   private String address;
   private Date birthday;
   private String photo="default.jpg";
   private Integer depid;
   //页面有关的东西
   private String depname;
   private String[] wids;
   private List<Welfare> lswf;
   
   private float emoney;
   private String sdate;
   private MultipartFile pic;
@Override
public String toString() {
	return "Emp [eid=" + eid + ", ename=" + ename + ", sex=" + sex + ", address=" + address + ", birthday=" + birthday
			+ ", photo=" + photo + ", depid=" + depid + ", depname=" + depname + ", wids=" + Arrays.toString(wids)
			+ ", emoney=" + emoney + ", sdate=" + sdate + ", pic=" + pic + "]";
}
public Integer getEid() {
	return eid;
}
public void setEid(Integer eid) {
	this.eid = eid;
}
public String getEname() {
	return ename;
}
public void setEname(String ename) {
	this.ename = ename;
}

public String[] getWids() {
	return wids;
}
public void setWids(String[] wids) {
	this.wids = wids;
}
public List<Welfare> getLswf() {
	return lswf;
}
public void setLswf(List<Welfare> lswf) {
	this.lswf = lswf;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public Date getBirthday() {
	return birthday;
}
public void setBirthday(Date birthday) {
	this.birthday = birthday;
}
public String getPhoto() {
	return photo;
}
public void setPhoto(String photo) {
	this.photo = photo;
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

public float getEmoney() {
	return emoney;
}
public void setEmoney(float emoney) {
	this.emoney = emoney;
}
public String getSdate() {
	sdate=new SimpleDateFormat("yyyy-MM-dd").format(birthday);
	return sdate;
}
public void setSdate(String sdate) {
	try {
		birthday=new SimpleDateFormat("yyyy-MM-dd").parse(sdate);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	this.sdate = sdate;
}
public MultipartFile getPic() {
	return pic;
}
public void setPic(MultipartFile pic) {
	this.pic = pic;
}
public Emp(Integer eid, String ename, String sex, String address, Date birthday, String photo, Integer depid,
		String depname, String[] wids, float emoney, String sdate, MultipartFile pic) {
	super();
	this.eid = eid;
	this.ename = ename;
	this.sex = sex;
	this.address = address;
	this.birthday = birthday;
	this.photo = photo;
	this.depid = depid;
	this.depname = depname;
	this.wids = wids;
	this.emoney = emoney;
	this.sdate = sdate;
	this.pic = pic;
}
public Emp() {
	super();
	// TODO Auto-generated constructor stub
}
public Emp(String ename, String sex, String address, Date birthday, String photo, Integer depid, String depname,
		String[] wids, float emoney, String sdate, MultipartFile pic) {
	super();
	this.ename = ename;
	this.sex = sex;
	this.address = address;
	this.birthday = birthday;
	this.photo = photo;
	this.depid = depid;
	this.depname = depname;
	this.wids = wids;
	this.emoney = emoney;
	this.sdate = sdate;
	this.pic = pic;
}
   
   	
}
