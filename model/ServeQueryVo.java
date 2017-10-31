package com.guigu.crm.model;

import java.util.List;

/**       
 * 项目名称：CRM_SAN   
 * 类全名:com.guigu.crm.model.ServeQueryVo  
 * 类描述：     
 * 创建人：guigu 
 * 创建时间：2017-9-7 下午5:26:26    
 * 修改备注：  
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


