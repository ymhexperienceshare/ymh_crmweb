package com.guigu.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guigu.crm.mapper.CrmActivityMapper;
import com.guigu.crm.model.ActivityQueryVo;
import com.guigu.crm.model.CrmActivity;
import com.guigu.crm.service.ActivityService;

/**       
 * 项目名称：CRM_SAN   
 * 类全名:com.guigu.crm.service.impl.ActivityServiceImpl  
 * 类描述：     
 * 创建人：guigu 
 * 创建时间：2017-9-6 下午12:45:23    
 * 修改备注：  
 * @version  jdk1.6  
 * 
 * Copyright (c) 2017, www.hzguigu.com All Rights Reserved.     
 */

@Service
public class ActivityServiceImpl implements ActivityService{

    @Autowired
     private CrmActivityMapper crmActivityMapper;
    
    //查询所有
    public List<CrmActivity> findAllActivities() throws Exception {
        List<CrmActivity> activityList=this.crmActivityMapper.selectByExample(null);
        return activityList;
    }

    //根据条件查询交往记录
    public List<CrmActivity> findByCondition(ActivityQueryVo activityQueryVo) throws Exception {
       
        List<CrmActivity> activityList=this.crmActivityMapper.selectByCondition(activityQueryVo);
        return activityList;
    }

    //根据id删除指定交往记录
    public void deleteActivity(Integer id) throws Exception {
        this.crmActivityMapper.deleteByPrimaryKey(id);
    }

    //添加交往记录
    public void addActivity(CrmActivity crmActivity) throws Exception {
        this.crmActivityMapper.insert(crmActivity);
    }

    //根据id查询
    public CrmActivity findActivityById(Integer id) throws Exception {
        CrmActivity activity=this.crmActivityMapper.selectByPrimaryKey(id);
        return activity;
    }

    //编辑
    public void editActivity(CrmActivity activity) throws Exception {
        this.crmActivityMapper.updateByPrimaryKey(activity);
    }

}


