package com.guigu.crm.model;

import java.util.Date;

public class CrmChange {
    private Integer id;

    private String source;

    private String custName;

    private String title;

    private Integer rate;

    private String linkman;

    private String tel;

    private String dese;

    private Integer createId;

    private String createBy;

    private Date createDate;

    private Integer dueId;

    private String dueTo;

    private Date dueDate;

    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName == null ? null : custName.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman == null ? null : linkman.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getDese() {
        return dese;
    }

    public void setDese(String dese) {
        this.dese = dese == null ? null : dese.trim();
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getDueId() {
        return dueId;
    }

    public void setDueId(Integer dueId) {
        this.dueId = dueId;
    }

    public String getDueTo() {
        return dueTo;
    }

    public void setDueTo(String dueTo) {
        this.dueTo = dueTo == null ? null : dueTo.trim();
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}