package com.guigu.crm.service;

import java.util.List;

import com.guigu.crm.model.CrmOrdersLine;
import com.guigu.crm.model.CrmService;
import com.guigu.crm.model.CustomerOrderOrderDetail;

/**       
 * ��Ŀ���ƣ�CRM_SAN   
 * ��ȫ��:com.guigu.crm.service.ExportToExcelService  
 * ��������     
 * �����ˣ�guigu 
 * ����ʱ�䣺2017-9-7 ����7:43:00    
 * �޸ı�ע��  
 * @version  jdk1.6  
 * 
 * Copyright (c) 2017, www.hzguigu.com All Rights Reserved.     
 */
public interface ExportToExcelService {

    List<CustomerOrderOrderDetail> findOrderDetailOfCustomer()throws Exception;
    
   CrmOrdersLine queryOrderDetailByOrderId(Integer orderId)throws Exception;
   
   /*===================*/
   //�����ͻ�����ͳ�Ʊ���
   List<CrmService> findAllService()throws Exception;
    
}


