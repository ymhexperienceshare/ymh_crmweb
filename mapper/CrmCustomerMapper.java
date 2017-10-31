package com.guigu.crm.mapper;

import com.guigu.crm.model.CrmCustomer;
import com.guigu.crm.model.CrmCustomerExample;
import com.guigu.crm.model.CustomerQueryVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CrmCustomerMapper {
    int countByExample(CrmCustomerExample example);

    int deleteByExample(CrmCustomerExample example);

    int deleteByPrimaryKey(String no);

    int insert(CrmCustomer record);

    int insertSelective(CrmCustomer record);

    List<CrmCustomer> selectByExample(CrmCustomerExample example);

    CrmCustomer selectByPrimaryKey(String no);

    int updateByExampleSelective(@Param("record") CrmCustomer record, @Param("example") CrmCustomerExample example);

    int updateByExample(@Param("record") CrmCustomer record, @Param("example") CrmCustomerExample example);

    int updateByPrimaryKeySelective(CrmCustomer record);

    int updateByPrimaryKey(CrmCustomer record);
    
    /*==================================================*/
    
    List<CrmCustomer> queryCustomerByCondition(CustomerQueryVo customerQueryVo)throws Exception;
    
    
    
}