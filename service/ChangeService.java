package com.guigu.crm.service;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.guigu.crm.model.ChangeQueryVo;
import com.guigu.crm.model.CrmChange;

/**       
 * 项目名称：CRM_SAN   
 * 类全名:com.guigu.crm.service.ChangeService  
 * 类描述：     
 * 创建人：guigu 
 * 创建时间：2017-9-5 下午1:10:48    
 * 修改备注：  
 * @version  jdk1.6  
 * 
 * Copyright (c) 2017, www.hzguigu.com All Rights Reserved.     
 */
public interface ChangeService {
    
    //销售机会查询
    public List<CrmChange> findChangeList(ChangeQueryVo changeQueryVo);
    
    //根据id查询销售机会
    public CrmChange findChangeById(Integer id) throws Exception;
    
    //修改销售机会
    public void updateChange(CrmChange crmChange) throws Exception;
    
    //删除销售机会
    public void deleteChange(Integer id) throws Exception;
    
    //增加销售机会
    public void addChange(CrmChange crmChange) throws Exception;
    
}


