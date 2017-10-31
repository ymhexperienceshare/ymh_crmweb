package com.guigu.crm.model;

import java.util.List;

/**       
 * ��Ŀ���ƣ�CRM_SAN   
 * ��ȫ��:com.guigu.crm.model.CustomerQueryVo  
 * ��������     
 * �����ˣ�guigu 
 * ����ʱ�䣺2017-9-7 ����9:37:42    
 * �޸ı�ע��  
 * @version  jdk1.6  
 * 
 * Copyright (c) 2017, www.hzguigu.com All Rights Reserved.     
 */
public class CustomerQueryVo {

    private CrmCustomer crmCustomer;
    
    private List<CrmCustomer> customerList;
    
    private Integer level;
    
    private Integer status;
    
    

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public CrmCustomer getCrmCustomer() {
        return crmCustomer;
    }

    public void setCrmCustomer(CrmCustomer crmCustomer) {
        this.crmCustomer = crmCustomer;
    }

    public List<CrmCustomer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<CrmCustomer> customerList) {
        this.customerList = customerList;
    }
    
    
    
}


