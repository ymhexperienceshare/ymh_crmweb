package com.guigu.crm.model;

import java.util.Date;

public class CrmPlan {
    private Integer id;

    private Integer chcId;

    private Date date;

    private String todo;

    private String result;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getChcId() {
        return chcId;
    }

    public void setChcId(Integer chcId) {
        this.chcId = chcId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo == null ? null : todo.trim();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    @Override
    public String toString() {
        return "CrmPlan [id=" + id + ", chcId=" + chcId + ", date=" + date + ", todo=" + todo + ", result=" + result
                + "]";
    }
    
    
}