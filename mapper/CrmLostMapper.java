package com.guigu.crm.mapper;

import com.guigu.crm.model.CrmLost;
import com.guigu.crm.model.CrmLostExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CrmLostMapper {
    int countByExample(CrmLostExample example);

    int deleteByExample(CrmLostExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CrmLost record);

    int insertSelective(CrmLost record);

    List<CrmLost> selectByExample(CrmLostExample example);

    CrmLost selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CrmLost record, @Param("example") CrmLostExample example);

    int updateByExample(@Param("record") CrmLost record, @Param("example") CrmLostExample example);

    int updateByPrimaryKeySelective(CrmLost record);

    int updateByPrimaryKey(CrmLost record);
}