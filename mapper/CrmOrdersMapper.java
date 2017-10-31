package com.guigu.crm.mapper;

import com.guigu.crm.model.CrmOrders;
import com.guigu.crm.model.CrmOrdersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CrmOrdersMapper {
    int countByExample(CrmOrdersExample example);

    int deleteByExample(CrmOrdersExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CrmOrders record);

    int insertSelective(CrmOrders record);

    List<CrmOrders> selectByExample(CrmOrdersExample example);

    CrmOrders selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CrmOrders record, @Param("example") CrmOrdersExample example);

    int updateByExample(@Param("record") CrmOrders record, @Param("example") CrmOrdersExample example);

    int updateByPrimaryKeySelective(CrmOrders record);

    int updateByPrimaryKey(CrmOrders record);
    
    /*===================================*/
    List<CrmOrders> queryOrdersByCustno(String custno)throws Exception;
    
    
    
}