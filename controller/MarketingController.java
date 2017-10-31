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
 * ��Ŀ���ƣ�CRM_SAN   
 * ��ȫ��:com.guigu.crm.controller.MarketingController  
 * ��������     
 * �����ˣ�guigu 
 * ����ʱ�䣺2017-9-5 ����1:55:00    
 * �޸ı�ע��  
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
    
    //�����Ʒ����
    //itemtypes ��ʾ��������ֵ����ڵ�request���� keyΪitemtypes
    @ModelAttribute("itemtypes")
    public Map<String, String> getItemType(){
        Map<String, String> itemTypes=new HashMap<String, String>();
        //�����ݿ��ȡ
        //List<CrmPlan> planList=marketService.findPlanList(null);
        //ServeService serveService = new ServeServiceImpl();
        List<CrmChange> list = changeService.findChangeList(null);
        for(CrmChange i : list){
            itemTypes.put(i.getId()+"", i.getId()+"");
        }
//        itemTypes.put("104", "����");
//        itemTypes.put("103", "³���ߺ�");
//        itemTypes.put("102", "¶��");
//        itemTypes.put("101", "���Ѿ�");
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


