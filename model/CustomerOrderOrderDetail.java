package com.guigu.crm.model;

import java.util.Date;

/**       
 * ��Ŀ���ƣ�CRM_SAN   
 * ��ȫ��:com.guigu.crm.model.CustomerOrderOrderDetail  
 * ��������     
 * �����ˣ�guigu 
 * ����ʱ�䣺2017-9-7 ����7:19:42    
 * �޸ı�ע��  
 * @version  jdk1.6  
 * 
 * Copyright (c) 2017, www.hzguigu.com All Rights Reserved.     
 */
public class CustomerOrderOrderDetail {

    private String customerNo;
    
    private String customerName;
    
    private Integer customerLevel;
    
    private Integer orderId;
    
    private Date orderDate;
    
    private String orderAddr;
    
    private Integer detailCount;
    
    private Integer detailPrice;

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getCustomerLevel() {
        return customerLevel;
    }

    public void setCustomerLevel(Integer customerLevel) {
        this.customerLevel = customerLevel;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderAddr() {
        return orderAddr;
    }

    public void setOrderAddr(String orderAddr) {
        this.orderAddr = orderAddr;
    }

    public Integer getDetailCount() {
        return detailCount;
    }

    public void setDetailCount(Integer detailCount) {
        this.detailCount = detailCount;
    }

    public Integer getDetailPrice() {
        return detailPrice;
    }

    public void setDetailPrice(Integer detailPrice) {
        this.detailPrice = detailPrice;
    }
    
    
    
    
}


