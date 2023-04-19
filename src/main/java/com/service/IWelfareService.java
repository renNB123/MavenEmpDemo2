package com.service;
/**
*@author 作者:任徳毓
*
*
*@date 创建时间: 2023年4月13日下午6:31:37
*/

import java.util.List;

import org.springframework.stereotype.Service;


import com.po.Welfare;

public interface IWelfareService {
	
  public List<Welfare> findAll();

}
