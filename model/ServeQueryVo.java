package com.guigu.crm.model;

import java.util.List;

/**       
 * ��Ŀ���ƣ�CRM_SAN   
 * ��ȫ��:com.guigu.crm.model.ServeQueryVo  
 * ��������     
 * �����ˣ�guigu 
 * ����ʱ�䣺2017-9-7 ����5:26:26    
 * �޸ı�ע��  
 * @version  jdk1.6  
 * 
 * Copyright (c) 2017, www.hzguigu.com All Rights Reserved.     
 */
public class ServeQueryVo {

    private CrmService crmService;
    
    private List<CrmService> crmServiceList;

    public CrmService getCrmService() {
        return crmService;
    }

    public void setCrmService(CrmService crmService) {
        this.crmService = crmService;
    }

    public List<CrmService> getCrmServiceList() {
        return crmServiceList;
    }

    public void setCrmServiceList(List<CrmService> crmServiceList) {
        this.crmServiceList = crmServiceList;
    }
    
    
}


