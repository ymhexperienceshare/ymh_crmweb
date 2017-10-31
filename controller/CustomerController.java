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
 * ��Ŀ���ƣ�CRM_SAN   
 * ��ȫ��:com.guigu.crm.controller.CustomerController  
 * ��������     
 * �����ˣ�guigu 
 * ����ʱ�䣺2017-9-5 ����3:02:06    
 * �޸ı�ע��  
 * @version  jdk1.6  
 * 
 * Copyright (c) 2017, www.hzguigu.com All Rights Reserved.     
 */
@Controller
public class CustomerController {

    //�����ʵ�������
    @Autowired
    private CustomerService customerService;
    
    //��ѯ���пͻ���Ϣ���ؼ���
    @RequestMapping(value="listAllCustomers")
    public String queryAllCustomers(Model model)throws Exception{
        
        List<CrmCustomer> customerList=this.customerService.findAllCustomers();
        model.addAttribute("customerList", customerList);
        
        return "customer_ymh/customerList";
    }
    
    //ɾ���ͻ���Ϣ
    @RequestMapping(value="deleteCustomer")
    public String deleteCustomer(String no)throws Exception{
        
        //����service��ʵ�������ִ��ɾ����������
        this.customerService.removeCustomerByNo(no);
        return "redirect:listAllCustomers.action";
    }
    
    //��ӿͻ��ĳ������޷�ֱ����ת��WEB-INFĿ¼�µ�JSPҳ�棬ͨ��Action��ת
    @RequestMapping(value="forwardToAddJSP")
    public String forwardToAddJSP()throws Exception{
    	return "customer_ymh/addCustomer";
    }
    
    //��ӿͻ�
    @RequestMapping(value="addCustomer")
    public String addCustomer(@Validated CrmCustomer customer,BindingResult bindingResult,Model model)throws Exception{
    	
        //����ӵĿͻ���Ϣ����У��
        if(bindingResult.hasErrors())
        {
            model.addAttribute("customerErrors", bindingResult.getAllErrors());
            return "customer_ymh/addCustomer";
        }
        
        //����service��ʵ����ִ����Ӳ�������
    	this.customerService.addCustomer(customer);
    	return "redirect:listAllCustomers.action";
    }
    
    
    //�޸��û�ǰ����
    @RequestMapping(value="editCustomer")
    public String editCustomer(String no,Model model)throws Exception{
    	
    	CrmCustomer customer=this.customerService.findCustomerByNo(no);
    	if(customer!=null)
    	{
    		model.addAttribute("customer", customer);
    	}
    	return "customer_ymh/editCustomer";
    }
    
    //�ύ�޸Ŀͻ�
    @RequestMapping(value="editCustomerSubmit")
    public String editCustomerSubmit(@ModelAttribute("customer")@Validated CrmCustomer customer,BindingResult bindingResult,Model model)throws Exception{
    	
        //����ӵĿͻ���Ϣ����У��
        if(bindingResult.hasErrors())
        {
            model.addAttribute("customerErrors", bindingResult.getAllErrors());
            return "customer_ymh/editCustomer";
        }
        
    	this.customerService.updateCustomer(customer);
    	return "redirect:listAllCustomers.action";
    }
    
}


