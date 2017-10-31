package com.guigu.crm.model;

import java.util.List;

/**       
 * 项目名称：CRM_SAN   
 * 类全名:com.guigu.crm.model.OrderOperatorVo  
 * 类描述：     
 * 创建人：guigu 
 * 创建时间：2017-9-7 下午6:25:42    
 * 修改备注：  
 * @version  jdk1.6  
 * 
 * Copyright (c) 2017, www.hzguigu.com All Rights Reserved.     
 */
public class OrderOperatorVo {

    private List<CrmOrders> orderList;

    public List<CrmOrders> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<CrmOrders> orderList) {
        this.orderList = orderList;
    }
    
    
    
}


