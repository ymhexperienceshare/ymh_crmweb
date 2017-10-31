package com.guigu.crm.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.guigu.crm.controller.validation.ValidGroup1;
import com.guigu.crm.controller.validation.ValidGroup2;

/**       
 * 项目名称：CRM_SAN   
 * 类全名:com.guigu.crm.model.CrmUserCustom  
 * 类描述：     
 * 创建人：guigu 
 * 创建时间：2017-9-5 下午3:59:23    
 * 修改备注：  
 * @version  jdk1.6  
 * 
 * Copyright (c) 2017, www.hzguigu.com All Rights Reserved.     
 */
public class CrmUserCustom extends CrmUser{
	
	private String yzm;
    
    public String getYzm() {
		return yzm;
	}

	public void setYzm(String yzm) {
		this.yzm = yzm;
	}

	private Integer roleid;

    private String rolename;

    private String roledesc;

    private Integer roleflag;
    
    @NotBlank(message="{CrmUserCustom.oldpassword.isBlank}",groups={ValidGroup2.class})
    @NotNull(message="{CrmUserCustom.oldpassword.isNull}",groups={ValidGroup2.class})
    private String oldpassword;
    
    @NotBlank(message="{CrmUserCustom.newpassword.isBlank}",groups={ValidGroup2.class})
    @Size(min=3,max=10,message="{CrmUser.newpassword.length.error}",groups={ValidGroup2.class})
    private String newpassword;
    
    private String parentCode;

    public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getOldpassword() {
        return oldpassword;
    }

    public void setOldpassword(String oldpassword) {
        this.oldpassword = oldpassword;
    }

    public String getNewpassword() {
        return newpassword;
    }

    public void setNewpassword(String newpassword) {
        this.newpassword = newpassword;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getRoledesc() {
        return roledesc;
    }

    public void setRoledesc(String roledesc) {
        this.roledesc = roledesc;
    }

    public Integer getRoleflag() {
        return roleflag;
    }

    public void setRoleflag(Integer roleflag) {
        this.roleflag = roleflag;
    }


}


