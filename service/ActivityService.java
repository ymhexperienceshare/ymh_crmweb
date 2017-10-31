package com.guigu.crm.service;

import java.util.List;

import com.guigu.crm.model.ActivityQueryVo;
import com.guigu.crm.model.CrmActivity;

/**       
 * 项目名称：CRM_SAN   
 * 类全名:com.guigu.crm.service.ActivityService  
 * 类描述：     
 * 创建人：guigu 
 * 创建时间：2017-9-6 下午12:44:23    
 * 修改备注：  
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


