package com.guigu.crm.model;

import java.util.List;

/**       
 * 项目名称：CRM_SAN   
 * 类全名:com.guigu.crm.model.ChangeQueryVo  
 * 类描述：     
 * 创建人：guigu 
 * 创建时间：2017-9-5 下午1:16:46    
 * 修改备注：  
 * @version  jdk1.6  
 * 
 * Copyright (c) 2017, www.hzguigu.com All Rights Reserved.     
 */
public class ChangeQueryVo {

    private CrmChange change;
    
    private List<CrmChange> changeList;

    public CrmChange getChange() {
        return change;
    }

    public void setChange(CrmChange change) {
        this.change = change;
    }

    public List<CrmChange> getChangeList() {
        return changeList;
    }

    public void setChangeList(List<CrmChange> changeList) {
        this.changeList = changeList;
    }
    
    
}


