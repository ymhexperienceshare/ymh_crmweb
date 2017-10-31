package com.guigu.crm.mapper;

import java.util.List;

import com.guigu.crm.model.CustomerOrderOrderDetail;

/**       
 * 项目名称：CRM_SAN   
 * 类全名:com.guigu.crm.mapper.ExportOrderDetailMapper  
 * 类描述：     
 * 创建人：guigu 
 * 创建时间：2017-9-7 下午7:30:56    
 * 修改备注：  
 * @version  jdk1.6  
 * 
 * Copyright (c) 2017, www.hzguigu.com All Rights Reserved.     
 */
public interface ExportOrderDetailMapper {

    List<CustomerOrderOrderDetail> queryOrderDetailOfCustomer()throws Exception;
    
}


