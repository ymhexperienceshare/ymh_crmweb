package com.guigu.crm.model;

import java.util.Date;

public class CrmService {
    private Long id;

    private String type;

    private String title;

    private String custNo;

    private String custName;

    private String status;

    private String request;

    private Integer createId;

    private String createBy;

    private Date createDate;

    private Integer dueId;

    private String dueTo;

    private Date dueDate;

    private String deal;

    private Integer dealId;

    private String dealBy;

    private Date dealDate;

    private String result;

    private Integer satisfy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo == null ? null : custNo.trim();
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName == null ? null : custName.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request == null ? null : request.trim();
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

    public String getDeal() {
        return deal;
    }

    public void setDeal(String deal) {
        this.deal = deal == null ? null : deal.trim();
    }

    public Integer getDealId() {
        return dealId;
    }

    public void setDealId(Integer dealId) {
        this.dealId = dealId;
    }

    public String getDealBy() {
        return dealBy;
    }

    public void setDealBy(String dealBy) {
        this.dealBy = dealBy == null ? null : dealBy.trim();
    }

    public Date getDealDate() {
        return dealDate;
    }

    public void setDealDate(Date dealDate) {
        this.dealDate = dealDate;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    public Integer getSatisfy() {
        return satisfy;
    }

    public void setSatisfy(Integer satisfy) {
        this.satisfy = satisfy;
    }
}