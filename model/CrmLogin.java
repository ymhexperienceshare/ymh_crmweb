package com.guigu.crm.model;

import java.util.Date;

public class CrmLogin {
    private Integer loginId;

    private Integer userId;

    private String loginIp;

    private Date loginDate;
    
    //判断是否是同一个登录
    @Override
	public boolean equals(Object obj) {
		if(obj==null || (obj instanceof CrmLogin)){
			return false;
		}
		CrmLogin other = (CrmLogin) obj;
		return userId.equals(other.getUserId());
	}

    public Integer getLoginId() {
        return loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp == null ? null : loginIp.trim();
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }
}