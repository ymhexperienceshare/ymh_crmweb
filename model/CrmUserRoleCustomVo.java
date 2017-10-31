package com.guigu.crm.model;

import java.util.List;


/**       
 * ��Ŀ���ƣ�CRM_SAN   
 * ��ȫ��:com.guigu.crm.model.CrmUserRoleCustomVo  
 * ��������     
 * �����ˣ�guigu 
 * ����ʱ�䣺2017-9-6 ����11:13:07    
 * �޸ı�ע��  
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


