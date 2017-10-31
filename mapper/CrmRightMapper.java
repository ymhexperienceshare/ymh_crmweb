package com.guigu.crm.mapper;

import com.guigu.crm.model.CrmRight;
import com.guigu.crm.model.CrmRightExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CrmRightMapper {
    int countByExample(CrmRightExample example);

    int deleteByExample(CrmRightExample example);

    int deleteByPrimaryKey(String code);

    int insert(CrmRight record);

    int insertSelective(CrmRight record);

    List<CrmRight> selectByExample(CrmRightExample example);

    CrmRight selectByPrimaryKey(String code);

    int updateByExampleSelective(@Param("record") CrmRight record, @Param("example") CrmRightExample example);

    int updateByExample(@Param("record") CrmRight record, @Param("example") CrmRightExample example);

    int updateByPrimaryKeySelective(CrmRight record);

    int updateByPrimaryKey(CrmRight record);
}