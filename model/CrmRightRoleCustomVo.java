package com.guigu.crm.model;
/**       
 * 项目名称：CRM_SAN   
 * 类全名:com.guigu.crm.model.CrmRightRoleCustomVo  
 * 类描述：     
 * 创建人：guigu 
 * 创建时间：2017-9-7 上午11:16:44    
 * 修改备注：  
 * @version  jdk1.6  
 * 
 * Copyright (c) 2017, www.hzguigu.com All Rights Reserved.     
 */
public class CrmRightRoleCustomVo {
    
    private CrmRight crmRight;
    
    private CrmRoleCustom crmRoleCustom;
    
    private CrmRole crmRole;
    
    private CrmRoleCustom roleCustom;

    public CrmRight getCrmRight() {
        return crmRight;
    }

    public void setCrmRight(CrmRight crmRight) {
        this.crmRight = crmRight;
    }

    public CrmRoleCustom getCrmRoleCustom() {
        return crmRoleCustom;
    }

    public void setCrmRoleCustom(CrmRoleCustom crmRoleCustom) {
        this.crmRoleCustom = crmRoleCustom;
    }

    public CrmRole getCrmRole() {
        return crmRole;
    }

    public void setCrmRole(CrmRole crmRole) {
        this.crmRole = crmRole;
    }

    public CrmRoleCustom getRoleCustom() {
        return roleCustom;
    }

    public void setRoleCustom(CrmRoleCustom roleCustom) {
        this.roleCustom = roleCustom;
    }

}


