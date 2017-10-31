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
 * 项目名称：CRM_SAN   
 * 类全名:com.guigu.crm.controller.OrderController  
 * 类描述：     
 * 创建人：guigu 
 * 创建时间：2017-9-7 下午3:51:38    
 * 修改备注：  
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
    
    
    //批量修改订单信息 
    @RequestMapping(value="editMuchOrders")
    public String editMuchOrders(OrderOperatorVo operatorVo)throws Exception{
        
        //调用service层实现类对象  批量修改即可
        this.orderServiceImpl.editMuchOrder(operatorVo.getOrderList());
        
        return "redirect:listAllCustomers.action";
    }
    
    //删除订单
    @RequestMapping(value="deleteOrder")
    public String deleteOrder(Integer id)throws Exception{
        //调用service层执行删除即可
        this.orderServiceImpl.deleteOrderById(id);
        return "redirect:listAllCustomers.action";
    }
    
}


