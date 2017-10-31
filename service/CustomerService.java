package com.guigu.crm.service;

import java.util.List;

import com.guigu.crm.model.CrmCustomer;
import com.guigu.crm.model.CustomerQueryVo;


/**       
 * 项目名称：CRM_SAN   
 * 类全名:com.guigu.crm.service.CustomerService  
 * 类描述：     
 * 创建人：guigu 
 * 创建时间：2017-9-5 下午2:56:30    
 * 修改备注：  
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


