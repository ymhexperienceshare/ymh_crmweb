package com.guigu.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guigu.crm.mapper.CrmActivityMapper;
import com.guigu.crm.model.ActivityQueryVo;
import com.guigu.crm.model.CrmActivity;
import com.guigu.crm.service.ActivityService;

/**       
 * ��Ŀ���ƣ�CRM_SAN   
 * ��ȫ��:com.guigu.crm.service.impl.ActivityServiceImpl  
 * ��������     
 * �����ˣ�guigu 
 * ����ʱ�䣺2017-9-6 ����12:45:23    
 * �޸ı�ע��  
 * @version  jdk1.6  
 * 
 * Copyright (c) 2017, www.hzguigu.com All Rights Reserved.     
 */

@Service
public class ActivityServiceImpl implements ActivityService{

    @Autowired
     private CrmActivityMapper crmActivityMapper;
    
    //��ѯ����
    public List<CrmActivity> findAllActivities() throws Exception {
        List<CrmActivity> activityList=this.crmActivityMapper.selectByExample(null);
        return activityList;
    }

    //����������ѯ������¼
    public List<CrmActivity> findByCondition(ActivityQueryVo activityQueryVo) throws Exception {
       
        List<CrmActivity> activityList=this.crmActivityMapper.selectByCondition(activityQueryVo);
        return activityList;
    }

    //����idɾ��ָ��������¼
    public void deleteActivity(Integer id) throws Exception {
        this.crmActivityMapper.deleteByPrimaryKey(id);
    }

    //��ӽ�����¼
    public void addActivity(CrmActivity crmActivity) throws Exception {
        this.crmActivityMapper.insert(crmActivity);
    }

    //����id��ѯ
    public CrmActivity findActivityById(Integer id) throws Exception {
        CrmActivity activity=this.crmActivityMapper.selectByPrimaryKey(id);
        return activity;
    }

    //�༭
    public void editActivity(CrmActivity activity) throws Exception {
        this.crmActivityMapper.updateByPrimaryKey(activity);
    }

}


