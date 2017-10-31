package com.guigu.crm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.guigu.crm.model.CrmChange;
import com.guigu.crm.model.CrmPlan;
import com.guigu.crm.model.CrmService;
import com.guigu.crm.service.ChangeService;
import com.guigu.crm.service.MarketService;

/**       
 * 项目名称：CRM_SAN   
 * 类全名:com.guigu.crm.controller.MarketingController  
 * 类描述：     
 * 创建人：guigu 
 * 创建时间：2017-9-5 下午1:55:00    
 * 修改备注：  
 * @version  jdk1.6  
 * 
 * Copyright (c) 2017, www.hzguigu.com All Rights Reserved.     
 */ 
 
@Controller 
//@RequestMapping("") 
public class MarketingController { 
    
    @Autowired
    private ChangeService changeService;
    
    @Autowired
    private MarketService marketService;
    
    @RequestMapping("/planList")
    public ModelAndView findPlanList() throws Exception{

        List<CrmPlan> planList=marketService.findPlanList(null);
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.addObject("planList", planList);
        modelAndView.setViewName("market/marketList");
        return modelAndView;
    }
    
    //添加商品分类
    //itemtypes 表示方法返回值会存在到request域中 key为itemtypes
    @ModelAttribute("itemtypes")
    public Map<String, String> getItemType(){
        Map<String, String> itemTypes=new HashMap<String, String>();
        //从数据库读取
        //List<CrmPlan> planList=marketService.findPlanList(null);
        //ServeService serveService = new ServeServiceImpl();
        List<CrmChange> list = changeService.findChangeList(null);
        for(CrmChange i : list){
            itemTypes.put(i.getId()+"", i.getId()+"");
        }
//        itemTypes.put("104", "芈月");
//        itemTypes.put("103", "鲁班七号");
//        itemTypes.put("102", "露娜");
//        itemTypes.put("101", "王昭君");
        return itemTypes;
    }
    
    @RequestMapping("/addPlan")
    public ModelAndView addPlan(CrmPlan example) throws Exception{
        ModelAndView modelAndView =new ModelAndView();
        if(example.getId() == null){
            modelAndView.setViewName("market/addPlan");
            return modelAndView;
        }
        marketService.addPlan(example);
        List<CrmPlan> planList=marketService.findPlanList(null);
        
        modelAndView.addObject("planList", planList);
        modelAndView.setViewName("market/marketList");
        return modelAndView;
    }
    
    @RequestMapping("/editPlan")
    public ModelAndView editPlan(CrmPlan example) throws Exception{        
        marketService.updatePlan(example.getId(),example);
        List<CrmPlan> planList=marketService.findPlanList(null);
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.addObject("planList", planList);
        modelAndView.setViewName("market/marketList");
        return modelAndView;
    }
    
    @RequestMapping("/editPlanStart")
    public ModelAndView editPlan(Integer id) throws Exception{
        CrmPlan crmPlan = marketService.findPlanById(id);
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.addObject("crmPlan", crmPlan);
        modelAndView.setViewName("market/editPlan");
        return modelAndView;
    }
    
    @RequestMapping("/deletePlan")
    public ModelAndView deletePlan(Integer id) throws Exception{
        marketService.deletePlan(id);
        List<CrmPlan> planList=marketService.findPlanList(null);
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.addObject("planList", planList);
        modelAndView.setViewName("market/marketList");
        return modelAndView;
    }

}


