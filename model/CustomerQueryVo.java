package com.guigu.crm.model;

import java.util.List;

/**       
 * 项目名称：CRM_SAN   
 * 类全名:com.guigu.crm.model.CustomerQueryVo  
 * 类描述：     
 * 创建人：guigu 
 * 创建时间：2017-9-7 上午9:37:42    
 * 修改备注：  
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


