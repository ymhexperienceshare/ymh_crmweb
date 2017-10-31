package com.guigu.crm.service;

import java.util.List;

import com.guigu.crm.model.CrmCustomer;
import com.guigu.crm.model.CustomerQueryVo;


/**       
 * ��Ŀ���ƣ�CRM_SAN   
 * ��ȫ��:com.guigu.crm.service.CustomerService  
 * ��������     
 * �����ˣ�guigu 
 * ����ʱ�䣺2017-9-5 ����2:56:30    
 * �޸ı�ע��  
 * @version  jdk1.6  
 * 
 * Copyright (c) 2017, www.hzguigu.com All Rights Reserved.     
 */
public interface CustomerService {
  
    public List<CrmCustomer> findAllCustomers()throws Exception;
    
    public void removeCustomerByNo(String no)throws Exception;
    
    public void addCustomer(CrmCustomer customer)throws Exception;
    
    public CrmCustomer findCustomerByNo(String no)throws Exception;
    
    public void updateCustomer(CrmCustomer customer)throws Exception;
    
    public List<CrmCustomer> findCustomerByCondition(CustomerQueryVo customerQueryVo)throws Exception;
}


