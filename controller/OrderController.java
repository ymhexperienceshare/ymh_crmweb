package com.guigu.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guigu.crm.model.CrmOrders;
import com.guigu.crm.model.OrderOperatorVo;
import com.guigu.crm.service.impl.OrderServiceImpl;

/**       
 * ��Ŀ���ƣ�CRM_SAN   
 * ��ȫ��:com.guigu.crm.controller.OrderController  
 * ��������     
 * �����ˣ�guigu 
 * ����ʱ�䣺2017-9-7 ����3:51:38    
 * �޸ı�ע��  
 * @version  jdk1.6  
 * 
 * Copyright (c) 2017, www.hzguigu.com All Rights Reserved.     
 */

@Controller
public class OrderController {

    @Autowired
    private OrderServiceImpl orderServiceImpl;
    
    @RequestMapping(value="listCustomerOrders")
    public String listCustomerOrders(String no,Model model)throws Exception{
        List<CrmOrders> orderList=this.orderServiceImpl.findOrdersByCustno(no);
        if(orderList!=null && orderList.size()>0)
        {
            model.addAttribute("orderList", orderList);
        }
        return "order_ymh/listOrdersOfCustomer"; 
    }
    
    
    //�����޸Ķ�����Ϣ 
    @RequestMapping(value="editMuchOrders")
    public String editMuchOrders(OrderOperatorVo operatorVo)throws Exception{
        
        //����service��ʵ�������  �����޸ļ���
        this.orderServiceImpl.editMuchOrder(operatorVo.getOrderList());
        
        return "redirect:listAllCustomers.action";
    }
    
    //ɾ������
    @RequestMapping(value="deleteOrder")
    public String deleteOrder(Integer id)throws Exception{
        //����service��ִ��ɾ������
        this.orderServiceImpl.deleteOrderById(id);
        return "redirect:listAllCustomers.action";
    }
    
}


