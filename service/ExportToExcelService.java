package com.guigu.crm.service;

import java.util.List;

import com.guigu.crm.model.CrmOrdersLine;
import com.guigu.crm.model.CrmService;
import com.guigu.crm.model.CustomerOrderOrderDetail;

/**       
 * 项目名称：CRM_SAN   
 * 类全名:com.guigu.crm.service.ExportToExcelService  
 * 类描述：     
 * 创建人：guigu 
 * 创建时间：2017-9-7 下午7:43:00    
 * 修改备注：  
 * @version  jdk1.6  
 * 
 * Copyright (c) 2017, www.hzguigu.com All Rights Reserved.     
 */
public interface ExportToExcelService {

    List<CustomerOrderOrderDetail> findOrderDetailOfCustomer()throws Exception;
    
   CrmOrdersLine queryOrderDetailByOrderId(Integer orderId)throws Exception;
   
   /*===================*/
   //导出客户服务统计报表
   List<CrmService> findAllService()throws Exception;
    
}


