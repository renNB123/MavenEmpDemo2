package com.service;
/**
*@author ����:�Ώ�ع
*
*
*@date ����ʱ��: 2023��4��13������6:31:37
*/

import java.util.List;

import org.springframework.stereotype.Service;

import com.po.Dep;

public interface IDepService {
  public List<Dep> findAll();

}
