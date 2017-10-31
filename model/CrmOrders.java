package com.guigu.crm.model;

import java.util.Date;

public class CrmOrders {
    private Integer id;

    private String custtomer;

    private Date date;

    private String addr;

    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCusttomer() {
        return custtomer;
    }

    public void setCusttomer(String custtomer) {
        this.custtomer = custtomer == null ? null : custtomer.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}