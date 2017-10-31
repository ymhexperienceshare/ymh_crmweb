package com.guigu.crm.mapper;

import com.guigu.crm.model.CrmUser;
import com.guigu.crm.model.CrmUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CrmUserMapper {
    int countByExample(CrmUserExample example);

    int deleteByExample(CrmUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CrmUser record);

    int insertSelective(CrmUser record);

    List<CrmUser> selectByExample(CrmUserExample example);

    CrmUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CrmUser record, @Param("example") CrmUserExample example);

    int updateByExample(@Param("record") CrmUser record, @Param("example") CrmUserExample example);

    int updateByPrimaryKeySelective(CrmUser record);

    int updateByPrimaryKey(CrmUser record);
}