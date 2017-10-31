package com.guigu.crm.service;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.guigu.crm.model.ChangeQueryVo;
import com.guigu.crm.model.CrmChange;

/**       
 * ��Ŀ���ƣ�CRM_SAN   
 * ��ȫ��:com.guigu.crm.service.ChangeService  
 * ��������     
 * �����ˣ�guigu 
 * ����ʱ�䣺2017-9-5 ����1:10:48    
 * �޸ı�ע��  
 * @version  jdk1.6  
 * 
 * Copyright (c) 2017, www.hzguigu.com All Rights Reserved.     
 */
public interface ChangeService {
    
    //���ۻ����ѯ
    public List<CrmChange> findChangeList(ChangeQueryVo changeQueryVo);
    
    //����id��ѯ���ۻ���
    public CrmChange findChangeById(Integer id) throws Exception;
    
    //�޸����ۻ���
    public void updateChange(CrmChange crmChange) throws Exception;
    
    //ɾ�����ۻ���
    public void deleteChange(Integer id) throws Exception;
    
    //�������ۻ���
    public void addChange(CrmChange crmChange) throws Exception;
    
}


