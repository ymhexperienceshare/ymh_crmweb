package com.guigu.crm.model;
/**       
 * 项目名称：CRM_SAN   
 * 类全名:com.guigu.crm.model.CrmRightCustom  
 * 类描述：     
 * 创建人：guigu 
 * 创建时间：2017-9-6 上午11:09:42    
 * 修改备注：  
 * @version  jdk1.6  
 * 
 * Copyright (c) 2017, www.hzguigu.com All Rights Reserved.     
 */
public class CrmRightCustom extends CrmRight{
    
    private Integer roleid;

    private String rolename;

    private String roledesc;

    private Integer roleflag;
    
    private Integer id;

    private Integer roleId;

    private String roleCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
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


