package com.guigu.crm.model;

import java.util.Date;

/**       
 * ��Ŀ���ƣ�CRM_SAN   
 * ��ȫ��:com.guigu.crm.model.ActivityQueryVo  
 * ��������     
 * �����ˣ�guigu 
 * ����ʱ�䣺2017-9-6 ����1:09:57    
 * �޸ı�ע��  
 * @version  jdk1.6  
 * 
 * Copyright (c) 2017, www.hzguigu.com All Rights Reserved.     
 */
public class ActivityQueryVo {
    
    private CrmActivity activity;
    
    private Date preTime;  //��ʼʱ��
    
    private Date aftTime;  //��ֹʱ��

    private String customerMessage;//�ͻ���Ż�������Ϣ

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


