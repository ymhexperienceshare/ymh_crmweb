package com.guigu.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.crm.model.CrmCustomer;
import com.guigu.crm.service.CustomerService;

/**       
 * 项目名称：CRM_SAN   
 * 类全名:com.guigu.crm.controller.CustomerController  
 * 类描述：     
 * 创建人：guigu 
 * 创建时间：2017-9-5 下午3:02:06    
 * 修改备注：  
 * @version  jdk1.6  
 * 
 * Copyright (c) 2017, www.hzguigu.com All Rights Reserved.     
 */
@Controller
public class CustomerController {

    //服务层实现类对象
    @Autowired
    private CustomerService customerService;
    
    //查询所有客户信息返回集合
    @RequestMapping(value="listAllCustomers")
    public String queryAllCustomers(Model model)throws Exception{
        
        List<CrmCustomer> customerList=this.customerService.findAllCustomers();
        model.addAttribute("customerList", customerList);
        
        return "customer_ymh/customerList";
    }
    
    //删除客户信息
    @RequestMapping(value="deleteCustomer")
    public String deleteCustomer(String no)throws Exception{
        
        //调用service等实现类对象执行删除操作即可
        this.customerService.removeCustomerByNo(no);
        return "redirect:listAllCustomers.action";
    }
    
    //添加客户的超链接无法直接跳转到WEB-INF目录下的JSP页面，通过Action跳转
    @RequestMapping(value="forwardToAddJSP")
    public String forwardToAddJSP()throws Exception{
    	return "customer_ymh/addCustomer";
    }
    
    //添加客户
    @RequestMapping(value="addCustomer")
    public String addCustomer(@Validated CrmCustomer customer,BindingResult bindingResult,Model model)throws Exception{
    	
        //对添加的客户信息进行校验
        if(bindingResult.hasErrors())
        {
            model.addAttribute("customerErrors", bindingResult.getAllErrors());
            return "customer_ymh/addCustomer";
        }
        
        //调用service层实现类执行添加操作即可
    	this.customerService.addCustomer(customer);
    	return "redirect:listAllCustomers.action";
    }
    
    
    //修改用户前回显
    @RequestMapping(value="editCustomer")
    public String editCustomer(String no,Model model)throws Exception{
    	
    	CrmCustomer customer=this.customerService.findCustomerByNo(no);
    	if(customer!=null)
    	{
    		model.addAttribute("customer", customer);
    	}
    	return "customer_ymh/editCustomer";
    }
    
    //提交修改客户
    @RequestMapping(value="editCustomerSubmit")
    public String editCustomerSubmit(@ModelAttribute("customer")@Validated CrmCustomer customer,BindingResult bindingResult,Model model)throws Exception{
    	
        //对添加的客户信息进行校验
        if(bindingResult.hasErrors())
        {
            model.addAttribute("customerErrors", bindingResult.getAllErrors());
            return "customer_ymh/editCustomer";
        }
        
    	this.customerService.updateCustomer(customer);
    	return "redirect:listAllCustomers.action";
    }
    
}


