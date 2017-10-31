package com.guigu.crm.mapper;

import com.guigu.crm.model.CrmLogin;
import com.guigu.crm.model.CrmLoginExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CrmLoginMapper {
    int countByExample(CrmLoginExample example);

    int deleteByExample(CrmLoginExample example);

    int deleteByPrimaryKey(Integer loginId);

    int insert(CrmLogin record);

    int insertSelective(CrmLogin record);

    List<CrmLogin> selectByExample(CrmLoginExample example);

    CrmLogin selectByPrimaryKey(Integer loginId);

    int updateByExampleSelective(@Param("record") CrmLogin record, @Param("example") CrmLoginExample example);

    int updateByExample(@Param("record") CrmLogin record, @Param("example") CrmLoginExample example);

    int updateByPrimaryKeySelective(CrmLogin record);

    int updateByPrimaryKey(CrmLogin record);
}