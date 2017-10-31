package com.guigu.crm.mapper;

import com.guigu.crm.model.CrmOrdersLine;
import com.guigu.crm.model.CrmOrdersLineExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CrmOrdersLineMapper {
    int countByExample(CrmOrdersLineExample example);

    int deleteByExample(CrmOrdersLineExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CrmOrdersLine record);

    int insertSelective(CrmOrdersLine record);

    List<CrmOrdersLine> selectByExample(CrmOrdersLineExample example);

    CrmOrdersLine selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CrmOrdersLine record, @Param("example") CrmOrdersLineExample example);

    int updateByExample(@Param("record") CrmOrdersLine record, @Param("example") CrmOrdersLineExample example);

    int updateByPrimaryKeySelective(CrmOrdersLine record);

    int updateByPrimaryKey(CrmOrdersLine record);
    
    /*================================*/
    CrmOrdersLine findOrderDetailByOrderId(Integer orderId)throws Exception;
    
}