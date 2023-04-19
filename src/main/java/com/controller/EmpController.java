package com.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.po.Dep;
import com.po.Emp;
import com.po.PageBean;
import com.po.Welfare;
import com.util.AJAXUtils;
import com.util.ServiceUtil;


@Controller
public class EmpController {
	@Resource(name="ServiceUtil")
	private ServiceUtil ibiz;

	
	public ServiceUtil getIbiz() {
		return ibiz;
	}
	public void setIbiz(ServiceUtil ibiz) {
		this.ibiz = ibiz;
	}
@RequestMapping(value="save_Student.do")
public String save(HttpServletRequest request,HttpServletResponse response,Emp emp){
	  System.out.println("save:"+emp.toString());
		String realpath=request.getRealPath("/");
		/*********�ļ��ϴ�begin***********/
		//��ȡ�ļ��ϴ�����
		MultipartFile multipartFile=emp.getPic();
		if(multipartFile!=null && !multipartFile.isEmpty()){
			//��ȡ�ϴ��ļ�����
			String fname=multipartFile.getOriginalFilename();
			//��ȡ�ļ���׺
			if(fname.lastIndexOf(".")!=-1){
				//��ȡ��׺
				String ext=fname.substring(fname.lastIndexOf("."));
				//�����ϴ��ļ�����
				if((ext.equalsIgnoreCase(".jpg"))||(ext.equalsIgnoreCase(".jpeg"))){
					//������
					fname=new Date().getTime()+ext;
				}
			}
			//�����ļ���������ϴ�
			File dostFile=new File(realpath+"/uppic/"+fname);
			try {
				FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), dostFile);
				emp.setPhoto(fname);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/*********�ļ��ϴ�end***********/
		boolean flag=ibiz.getEmpservice().save(emp);
		if(flag){
			System.out.println("��ӳɹ�....");
			AJAXUtils.printString(response, "1");

			return null;
		}else{
			 AJAXUtils.printString(response, "0");
			return null;
		}
}
	@RequestMapping(value="update_Emp.do")
	public String update(HttpServletRequest request,HttpServletResponse response,Emp emp){
		//��ȡԭ����Ƭ����	
		 String oldfname=ibiz.getEmpservice().findById(emp.getEid()).getPhoto();
		
		String realpath=request.getRealPath("/");
		//*********�ļ��ϴ�begin***********//
		//��ȡ�ļ��ϴ�����
		MultipartFile multipartFile=emp.getPic();
		if(multipartFile!=null && !multipartFile.isEmpty()){
			//��ȡ�ϴ��ļ�����
			String fname=multipartFile.getOriginalFilename();
			//��ȡ�ļ���׺
			if(fname.lastIndexOf(".")!=-1){
				//��ȡ��׺
				String ext=fname.substring(fname.lastIndexOf("."));
				//�����ϴ��ļ�����
				if((ext.equalsIgnoreCase(".jpg"))||(ext.equalsIgnoreCase(".jpeg"))){
					//������
					fname=new Date().getTime()+ext;
				}
			}
			//�����ļ���������ϴ�
			File dostFile=new File(realpath+"/uppic/"+fname);
			try {
				FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), dostFile);
				emp.setPhoto(fname);
				//ɾ����Ƭ
				File oldfile=new File(realpath+"/uppic/"+oldfname);
				if(oldfile.exists() && !oldfname.equals("default.jpg")){
					oldfile.delete();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			emp.setPhoto(oldfname);
		}
		//*********�ļ��ϴ�end***********//*
		boolean flag=ibiz.getEmpservice().update(emp);
		if(flag){
			System.out.println("�޸ĳɹ�....");
			
			AJAXUtils.printString(response, "1");
			return null;
		}else{
			System.out.println("�޸�ʧ��....");
			AJAXUtils.printString(response, "0");
			
			return null;
		}
		
	}
	@RequestMapping(value="delById_Emp.do")
	public void delById(HttpServletRequest request,HttpServletResponse response,Integer eid){
		System.out.println("delById:"+eid);
		//��ȡԭ����Ƭ����
		String oldfname=ibiz.getEmpservice().findById(eid).getPhoto();
		String realpath=request.getRealPath("/");
		System.out.println(realpath);
		boolean flag=ibiz.getEmpservice().delById(eid);
		if(flag){
			//ɾ����Ƭ
			
			File oldfile=new File(realpath+"/uppic/"+oldfname);
			if(oldfile.exists() && !oldfname.equals("default.jpg")){
				oldfile.delete();
			}
			AJAXUtils.printString(response, "1");
		}else{
		    AJAXUtils.printString(response, "0");
		}
	}
	@RequestMapping(value="findById_Emp.do")
	public void findById(HttpServletRequest request,HttpServletResponse response,Integer eid){
		
		System.out.println("findById:"+eid);
		
		Emp oldst=ibiz.getEmpservice().findById(eid);
		System.out.println("����"+oldst.toString());
		
		PropertyFilter propertyFilter=AJAXUtils.filterProperts("birthday");
		String jsonStr=JSONObject.toJSONString(oldst,propertyFilter,SerializerFeature.DisableCircularReferenceDetect);
		AJAXUtils.printString(response, jsonStr);	
	}
	@RequestMapping(value="findPageAll_Student.do")
	public void findPageAll(HttpServletRequest request,HttpServletResponse response,Integer page,Integer rows){
		System.out.println("findPageAll��page=="+page+"==rows==="+rows);
		
		//��session��ȡ��ҳʵ�����
		PageBean pb=new PageBean();
		//�ж��Ƿ��ǵ�һ�η�ҳ����ȡ������pb��
		
		page=page==null?pb.getPage():page;
		rows=rows==null?pb.getRows():rows;
		//����
		if(page<1)page=1;
		if(rows<1 || rows>20)rows=5;
		
		pb.setPage(page);
		pb.setRows(rows);
		//��ȡ��ǰҳ����
		List<Emp> lsst=ibiz.getEmpservice().findAll(pb);
		int Maxrows=ibiz.getEmpservice().findMaxRows();
		//��װ���ݵ�pb����
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("page", page);
		map.put("rows", lsst);
		map.put("total",Maxrows );
		
		String jsonStr=JSONObject.toJSONString(map);
		AJAXUtils.printString(response, jsonStr);	
	}
	
	@RequestMapping(value="doinit.do")
	public void doinit(HttpServletRequest request,HttpServletResponse response){
		System.out.println("doinit����........");
		List<Dep> lsdp=ibiz.getDepservice().findAll();
		List<Welfare> lswf=ibiz.getWfservice().findAll();
		Map<String, Object>  map=new HashMap<String, Object>();
		map.put("lsdp", lsdp);
		map.put("lswf", lswf);
		String jsonStr=JSONObject.toJSONString(map);
		AJAXUtils.printString(response, jsonStr);	
	}

}
