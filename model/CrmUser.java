package com.guigu.crm.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.guigu.crm.controller.validation.ValidGroup1;
import com.guigu.crm.controller.validation.ValidGroup2;
import com.guigu.crm.controller.validation.ValidGroup3;


public class CrmUser {
    
    private Integer userid;

    @NotBlank(message="{CrmUser.username.isBlank}",groups={ValidGroup1.class,ValidGroup2.class,ValidGroup3.class})
    @Size(min=1,max=15,message="{CrmUser.username.length.error}",groups={ValidGroup1.class,ValidGroup2.class})
    private String username;

    @NotBlank(message="{CrmUser.password.isBlank}",groups={ValidGroup1.class,ValidGroup3.class})
    @Size(min=3,max=10,message="{CrmUser.password.length.error}",groups={ValidGroup1.class})
    private String password;

    private Integer roleId;

    private Integer userflag;


    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getUserflag() {
        return userflag;
    }

    public void setUserflag(Integer userflag) {
        this.userflag = userflag;
    }

}