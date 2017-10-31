package com.guigu.crm.model;

import java.util.List;


/**       
 * 项目名称：CRM_SAN   
 * 类全名:com.guigu.crm.model.CrmUserRoleCustomVo  
 * 类描述：     
 * 创建人：guigu 
 * 创建时间：2017-9-6 上午11:13:07    
 * 修改备注：  
 * @version  jdk1.6  
 * 
 * Copyright (c) 2017, www.hzguigu.com All Rights Reserved.     
 */
public class CrmUserRoleCustomVo {
    
    private CrmUser crmUser;
    
    private CrmUserCustom crmUserCustom;
    
    private CrmRole crmRole;
    
    private CrmRoleCustom crmRoleCustom;
    
    private List<CrmUserCustom> crmUserCustomList;
    
    private List<CrmRoleCustom> crmRoleCustomList;

    public List<CrmUserCustom> getCrmUserCustomList() {
        return crmUserCustomList;
    }

    public void setCrmUserCustomList(List<CrmUserCustom> crmUserCustomList) {
        this.crmUserCustomList = crmUserCustomList;
    }

    public List<CrmRoleCustom> getCrmRoleCustomList() {
        return crmRoleCustomList;
    }

    public void setCrmRoleCustomList(List<CrmRoleCustom> crmRoleCustomList) {
        this.crmRoleCustomList = crmRoleCustomList;
    }

    public CrmUser getCrmUser() {
        return crmUser;
    }

    public void setCrmUser(CrmUser crmUser) {
        this.crmUser = crmUser;
    }

    public CrmUserCustom getCrmUserCustom() {
        return crmUserCustom;
    }

    public void setCrmUserCustom(CrmUserCustom crmUserCustom) {
        this.crmUserCustom = crmUserCustom;
    }

    public CrmRole getCrmRole() {
        return crmRole;
    }

    public void setCrmRole(CrmRole crmRole) {
        this.crmRole = crmRole;
    }

    public CrmRoleCustom getCrmRoleCustom() {
        return crmRoleCustom;
    }

    public void setCrmRoleCustom(CrmRoleCustom crmRoleCustom) {
        this.crmRoleCustom = crmRoleCustom;
    }

}


