package com.guigu.crm.mapper;

import java.util.List;

import com.guigu.crm.model.CustomerOrderOrderDetail;

/**       
 * ��Ŀ���ƣ�CRM_SAN   
 * ��ȫ��:com.guigu.crm.mapper.ExportOrderDetailMapper  
 * ��������     
 * �����ˣ�guigu 
 * ����ʱ�䣺2017-9-7 ����7:30:56    
 * �޸ı�ע��  
 * @version  jdk1.6  
 * 
 * Copyright (c) 2017, www.hzguigu.com All Rights Reserved.     
 */
public interface ExportOrderDetailMapper {

    List<CustomerOrderOrderDetail> queryOrderDetailOfCustomer()throws Exception;
    
}


