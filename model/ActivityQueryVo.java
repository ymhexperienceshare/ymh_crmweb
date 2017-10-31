package com.guigu.crm.model;

import java.util.Date;

/**       
 * 项目名称：CRM_SAN   
 * 类全名:com.guigu.crm.model.ActivityQueryVo  
 * 类描述：     
 * 创建人：guigu 
 * 创建时间：2017-9-6 下午1:09:57    
 * 修改备注：  
 * @version  jdk1.6  
 * 
 * Copyright (c) 2017, www.hzguigu.com All Rights Reserved.     
 */
public class ActivityQueryVo {
    
    private CrmActivity activity;
    
    private Date preTime;  //起始时间
    
    private Date aftTime;  //终止时间

    private String customerMessage;//客户编号或姓名信息

    public CrmActivity getActivity() {
        return activity;
    }

    public void setActivity(CrmActivity activity) {
        this.activity = activity;
    }

    public Date getPreTime() {
        return preTime;
    }

    public void setPreTime(Date preTime) {
        this.preTime = preTime;
    }

    public Date getAftTime() {
        return aftTime;
    }

    public void setAftTime(Date aftTime) {
        this.aftTime = aftTime;
    }

    public String getCustomerMessage() {
        return customerMessage;
    }

    public void setCustomerMessage(String customerMessage) {
        this.customerMessage = customerMessage;
    }
    
    
    
}


