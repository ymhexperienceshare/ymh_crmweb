package com.guigu.crm.service;

import java.util.List;

import com.guigu.crm.model.ActivityQueryVo;
import com.guigu.crm.model.CrmActivity;

/**       
 * ��Ŀ���ƣ�CRM_SAN   
 * ��ȫ��:com.guigu.crm.service.ActivityService  
 * ��������     
 * �����ˣ�guigu 
 * ����ʱ�䣺2017-9-6 ����12:44:23    
 * �޸ı�ע��  
 * @version  jdk1.6  
 * 
 * Copyright (c) 2017, www.hzguigu.com All Rights Reserved.     
 */
public interface ActivityService {

    public List<CrmActivity> findAllActivities()throws Exception;
    
    public List<CrmActivity> findByCondition(ActivityQueryVo activityQueryVo)throws Exception;
    
    public void deleteActivity(Integer id)throws Exception;
    
    public void addActivity(CrmActivity crmActivity)throws Exception;
    
    public CrmActivity findActivityById(Integer id)throws Exception;
    
    public void editActivity(CrmActivity activity)throws Exception;
}


