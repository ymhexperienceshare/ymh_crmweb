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
 * 项目名称：CRM_SAN   
 * 类全名:com.guigu.crm.controller.ActivityController  
 * 类描述：     
 * 创建人：guigu 
 * 创建时间：2017-9-6 上午11:32:31    
 * 修改备注：  
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
    
    //条件查询交往记录
    @RequestMapping(value="findActivityByCondition")
    public String findActivityByCondition(ActivityQueryVo activityQueryVo,Model model)throws Exception{
        
        //调用service层实现类对象根据条件查询交往记录
        List<CrmActivity> activityList=this.activityService.findByCondition(activityQueryVo);
        model.addAttribute("activityList", activityList);
        
        return "activity_ymh/activitiesList";
    }
    
    //根基id删除指定的交往记录
    @RequestMapping(value="deleteActivity")
    public String deleteActivity(Integer id)throws Exception{
        //执行删除即可
        this.activityService.deleteActivity(id);
        return "redirect:listAllActivity.action";
    }
    
    //仅仅作为跳转到添加页面的中转站
    @RequestMapping(value="toAddJSP")
    public String toAddJSP()throws Exception{
        return "activity_ymh/addActivity";
    }
    
    //添加交往记录
    @RequestMapping(value="addActivity")
    public String addActivity(@Validated CrmActivity crmActivity,BindingResult bindingResult,Model model)throws Exception{
       //执行数据校验
        if(bindingResult.hasErrors())
        {
            model.addAttribute("activityErrors", bindingResult.getAllErrors());
            return "activity_ymh/addActivity";
        }
        
        //执行添加操作即可
        this.activityService.addActivity(crmActivity);
        return "redirect:listAllActivity.action";
    }
    
    //编辑交往记录前的回显
    @RequestMapping(value="editActivity")
    public String editActivity(Integer id,Model model)throws Exception{
        //根据id查询
        CrmActivity activity=this.activityService.findActivityById(id);
        model.addAttribute("activity", activity);
        return "activity_ymh/editActivity";
    }
    
    //编辑提交
    @RequestMapping(value="editActivitySubmit")
    public String editActivitySubmit(@ModelAttribute("activity")@Validated CrmActivity activity,BindingResult bindingResult,Model model)throws Exception{
      //执行数据校验
        if(bindingResult.hasErrors())
        {
            model.addAttribute("activityErrors", bindingResult.getAllErrors());
            return "activity_ymh/editActivity";
        }
        
        this.activityService.editActivity(activity);
        return "redirect:listAllActivity.action";
    }
    
}


