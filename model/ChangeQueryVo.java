package com.guigu.crm.model;

import java.util.List;

/**       
 * ��Ŀ���ƣ�CRM_SAN   
 * ��ȫ��:com.guigu.crm.model.ChangeQueryVo  
 * ��������     
 * �����ˣ�guigu 
 * ����ʱ�䣺2017-9-5 ����1:16:46    
 * �޸ı�ע��  
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


