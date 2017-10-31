package com.guigu.crm.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.guigu.crm.model.ChangeQueryVo;
import com.guigu.crm.model.CrmChange;
import com.guigu.crm.model.CrmRole;
import com.guigu.crm.model.CrmRoleCustom;
import com.guigu.crm.model.CrmUser;
import com.guigu.crm.model.CrmUserCustom;
import com.guigu.crm.service.ChangeService;
import com.guigu.crm.service.RoleService;
import com.guigu.crm.service.SystemControllerService;
import com.guigu.crm.service.UserService;


/**       
 * 项目名称：CRM_SAN   
 * 类全名:com.guigu.crm.controller.ChangeController  
 * 类描述：     
 * 创建人：guigu 
 * 创建时间：2017-9-5 下午1:07:50    
 * 修改备注：  
 * @version  jdk1.6  
 * 
 * Copyright (c) 2017, www.hzguigu.com All Rights Reserved.     
 */

@Controller
@RequestMapping("/change")
public class ChangeController {
    
    @Autowired
    private ChangeService changeService;
    
  
    @Autowired
    private SystemControllerService systemControllerService;
    
    @Autowired
    private UserService userService;
    
    //销售机会的查询
    @RequestMapping("/queryChange")
    public ModelAndView queryChange(ChangeQueryVo changeQueryVo) throws Exception{
        
        List<CrmChange> changeList = changeService.findChangeList(changeQueryVo);
        
       List<CrmUser> userList = userService.CustomerManagerList();
       
       
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("changeList",changeList);
        modelAndView.addObject("userList", userList);
        modelAndView.setViewName("change/change");
        return modelAndView;
    }
    
    
    //销售机会的增加
    @RequestMapping("/addChange")
    public ModelAndView addChange() throws Exception{
        
        List<CrmUserCustom> userList = new ArrayList<CrmUserCustom>();
        List<CrmUserCustom> olduserList = systemControllerService.userRoleList(null);
        for(CrmUserCustom var:olduserList){
            if(var.getRoleId()==3) userList.add(var);
            
        }
       // List<CrmUser> userList = userService.CustomerManagerList();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userList", userList);
        modelAndView.setViewName("change/addChange");
        
        return modelAndView;
    }
    
    //添加提交
    @RequestMapping("/addChangeSubmit")
    public String addChangeSubmit(CrmChange  change)throws Exception{
           
        System.out.println(change.getSource());
        changeService.addChange(change);
        return "redirect:queryChange.action";
      
    }
    
    
    //销售机会的编辑
    @RequestMapping("/editChange")
    public ModelAndView editChange(Model model,@RequestParam(value="id",required=true)Integer id) throws Exception{
        
        List<CrmUserCustom> userList = new ArrayList<CrmUserCustom>();
        List<CrmUserCustom> olduserList = systemControllerService.userRoleList(null);
        for(CrmUserCustom var:olduserList){
            if(var.getRoleId()==3) userList.add(var);
            
        }
        CrmChange change = changeService.findChangeById(id);
        
        
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userList", userList);
        model.addAttribute("change", change);
        modelAndView.setViewName("change/editChange");
        
        return modelAndView;
    }
    
    
    //更新数据
    @RequestMapping("/editChangeSubmit")
    public String editChangeSubmit(CrmChange  change)throws Exception{
           
        changeService.updateChange(change);
        
      return "redirect:queryChange.action";
      
    }
    
     //删除
    @RequestMapping("/deleteChange")
    public String deleteOneItems(@RequestParam(value="id",required=true)Integer id)throws Exception{
        System.out.println(id+"delete");
        changeService.deleteChange(id);
        return "redirect:queryChange.action";
    }
    
  
}


