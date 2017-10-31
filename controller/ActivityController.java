package com.guigu.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.crm.model.ActivityQueryVo;
import com.guigu.crm.model.CrmActivity;
import com.guigu.crm.service.ActivityService;

/**       
 * ��Ŀ���ƣ�CRM_SAN   
 * ��ȫ��:com.guigu.crm.controller.ActivityController  
 * ��������     
 * �����ˣ�guigu 
 * ����ʱ�䣺2017-9-6 ����11:32:31    
 * �޸ı�ע��  
 * @version  jdk1.6  
 * 
 * Copyright (c) 2017, www.hzguigu.com All Rights Reserved.     
 */
@Controller
public class ActivityController {

    @Autowired
    private ActivityService activityService;
    
    @RequestMapping(value="listAllActivity")
    public String listAllActivity(Model model)throws Exception{
        List<CrmActivity> activityList=this.activityService.findAllActivities();
        if(activityList!=null && activityList.size()>0)
        {
            model.addAttribute("activityList", activityList);
        }
        return "activity_ymh/activitiesList";
    }
    
    //������ѯ������¼
    @RequestMapping(value="findActivityByCondition")
    public String findActivityByCondition(ActivityQueryVo activityQueryVo,Model model)throws Exception{
        
        //����service��ʵ����������������ѯ������¼
        List<CrmActivity> activityList=this.activityService.findByCondition(activityQueryVo);
        model.addAttribute("activityList", activityList);
        
        return "activity_ymh/activitiesList";
    }
    
    //����idɾ��ָ���Ľ�����¼
    @RequestMapping(value="deleteActivity")
    public String deleteActivity(Integer id)throws Exception{
        //ִ��ɾ������
        this.activityService.deleteActivity(id);
        return "redirect:listAllActivity.action";
    }
    
    //������Ϊ��ת�����ҳ�����תվ
    @RequestMapping(value="toAddJSP")
    public String toAddJSP()throws Exception{
        return "activity_ymh/addActivity";
    }
    
    //��ӽ�����¼
    @RequestMapping(value="addActivity")
    public String addActivity(@Validated CrmActivity crmActivity,BindingResult bindingResult,Model model)throws Exception{
       //ִ������У��
        if(bindingResult.hasErrors())
        {
            model.addAttribute("activityErrors", bindingResult.getAllErrors());
            return "activity_ymh/addActivity";
        }
        
        //ִ����Ӳ�������
        this.activityService.addActivity(crmActivity);
        return "redirect:listAllActivity.action";
    }
    
    //�༭������¼ǰ�Ļ���
    @RequestMapping(value="editActivity")
    public String editActivity(Integer id,Model model)throws Exception{
        //����id��ѯ
        CrmActivity activity=this.activityService.findActivityById(id);
        model.addAttribute("activity", activity);
        return "activity_ymh/editActivity";
    }
    
    //�༭�ύ
    @RequestMapping(value="editActivitySubmit")
    public String editActivitySubmit(@ModelAttribute("activity")@Validated CrmActivity activity,BindingResult bindingResult,Model model)throws Exception{
      //ִ������У��
        if(bindingResult.hasErrors())
        {
            model.addAttribute("activityErrors", bindingResult.getAllErrors());
            return "activity_ymh/editActivity";
        }
        
        this.activityService.editActivity(activity);
        return "redirect:listAllActivity.action";
    }
    
}


