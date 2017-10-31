package com.guigu.crm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.guigu.crm.model.CrmCustomer;
import com.guigu.crm.model.CrmService;
import com.guigu.crm.model.CrmUserCustom;
import com.guigu.crm.service.CustomerService;
import com.guigu.crm.service.ServeService;
import com.guigu.crm.service.SystemControllerService;
import com.guigu.crm.service.UserService;





/**       
 * 项目名称：CRM_SAN   
 * 类全名:com.guigu.crm.controller.ServeController  
 * 类描述：     
 * 创建人：hicoo 
 * 创建时间：2017-9-7 下午5:14:56    
 * 修改备注：  
 * @version  jdk1.6  
 * 
 * Copyright (c) 2017, www.hzguigu.com All Rights Reserved.     
 */
@Controller
public class ServeController {
    @Autowired
    private ServeService serveService;
    
    @Autowired
    private CustomerService customerService;

    
    @Autowired
    private SystemControllerService systemControllerService;
   
    @Autowired
    private UserService userService;

    @RequestMapping("/serveList")
    public ModelAndView serveList() throws Exception{
        List<CrmService> serveList =  serveService.findServeList();
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.addObject("serveList", serveList);
        modelAndView.setViewName("Serve/serveList");
        return modelAndView;
    }
    
    //分配
    @RequestMapping("/disServeList")
    public ModelAndView findHaveCreateService(){
        
        
        List<CrmUserCustom> userList = new ArrayList<CrmUserCustom>();
        List<CrmUserCustom> olduserList = systemControllerService.userRoleList(null);
        for(CrmUserCustom var:olduserList){
            if(var.getRoleId()==3) userList.add(var);
        }
       /* 
        List<CrmUser> olduserList = userService.CustomerManagerList();
        
        List<CrmUser> userList = new ArrayList<CrmUser>();
        for(CrmUser var:olduserList){
            if(var.getRoleId() == 2) userList.add(var); 
        }*/
        List<CrmService> haveCreateService = serveService.findHaveCreateService();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("haveCreateService", haveCreateService);
        modelAndView.addObject("userList",userList);

        modelAndView.setViewName("/Serve/disServeList");
        return modelAndView;

    }

    //分配提交
    @RequestMapping("/disServeListSubmit")
    public String addChangeSubmit(CrmService  crmService,BindingResult bindingResult)throws Exception{
      
     
        
        CrmService newCrmService = crmService;
        crmService = serveService.findCrmServiceById(crmService.getId());
        crmService.setDueId(newCrmService.getDueId());
        crmService.setDueDate(newCrmService.getDueDate());
        serveService.updateHaveCreateService(crmService);
        return "redirect:disServeList.action";

    }



    //处理
    @RequestMapping("/handleServeList")
    public ModelAndView findHaveDisService(){

        List<CrmService>  handleService = serveService.findHaveDisService();

        ModelAndView modelAndView = new ModelAndView();
       /* List<CrmUser> userList = userService.CustomerManagerList();*/
        List<CrmUserCustom> userList = new ArrayList<CrmUserCustom>();
        List<CrmUserCustom> olduserList = systemControllerService.userRoleList(null);
        for(CrmUserCustom var:olduserList){
            if(var.getRoleId()==3) userList.add(var);
        }
        modelAndView.addObject("userList",userList);
        modelAndView.addObject("handleService", handleService);
        modelAndView.setViewName("/Serve/handleServeList");
        return modelAndView;

    }



    //处理提交
    @RequestMapping("/handleServeListSubmit")
    public String handleServeListSubmit(CrmService  crmService)throws Exception{

        CrmService newCrmService = crmService;
        crmService = serveService.findCrmServiceById(crmService.getId());
        crmService.setResult(newCrmService.getResult());
        serveService.updateHaveDisService(crmService);
        return "redirect:handleServeList.action";

    }




    //反馈
    @RequestMapping("/backServeList")
    public ModelAndView findHaveHandleService(){

        List<CrmService> haveHandleService = serveService.findHaveHandleService();

        ModelAndView modelAndView = new ModelAndView();
     /*   List<CrmUser> userList = userService.CustomerManagerList();*/
        List<CrmUserCustom> userList = new ArrayList<CrmUserCustom>();
        List<CrmUserCustom> olduserList = systemControllerService.userRoleList(null);
        for(CrmUserCustom var:olduserList){
            if(var.getRoleId()==3) userList.add(var);
        }
        modelAndView.addObject("userList",userList);
        modelAndView.addObject("backService", haveHandleService);

        modelAndView.setViewName("/Serve/backServeList");
        return modelAndView;
    }


    //提交反馈 重新访问

    @RequestMapping("/backServeListSubmit")
    public String backServeListSubmit(CrmService  crmService)throws Exception{

        CrmService newCrmService = crmService;
        crmService = serveService.findCrmServiceById(crmService.getId());
        System.out.println(crmService.getId()+"   2313");
        crmService.setSatisfy(newCrmService.getSatisfy());
        if(crmService.getSatisfy() >3){
            serveService.updateHaveHandleService(crmService);

            return "redirect:backServeList.action";
        }

        else {
            newCrmService.setDueId(null);
            newCrmService.setDueDate(null);
            newCrmService.setResult(null);
            newCrmService.setSatisfy(null);
            serveService.updateNoPassService(crmService);
            return "redirect:backServeList.action";
        }
    }

    
    
    @RequestMapping("/serveListByCondition")
    public ModelAndView serveListByCondition() throws Exception{
        List<CrmService> serveList =  serveService.findServeList();
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.addObject("serveList", serveList);
        modelAndView.setViewName("market/marketList");
        return modelAndView;
    }
    
    @RequestMapping("/addServe")
    public String addServe(CrmService crmService) throws Exception{
        if(crmService.getId() == null)
            return "Serve/addServe";
        serveService.addService(crmService);
        return "home/main";
    }
    
    @ModelAttribute("itemtypes")
    public Map<String, String> getItemType() throws Exception{
        Map<String, String> itemTypes=new HashMap<String, String>();
        
        List<CrmCustomer> list = customerService.findAllCustomers();
        for(CrmCustomer i : list){
            itemTypes.put(i.getNo()+"", i.getNo()+"");
        }
        return itemTypes;
    }
    
    
}


