package com.guigu.crm.mapper;

import com.guigu.crm.model.CrmRole;
import com.guigu.crm.model.CrmRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CrmRoleMapper {
    int countByExample(CrmRoleExample example);

    int deleteByExample(CrmRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CrmRole record);

    int insertSelective(CrmRole record);

    List<CrmRole> selectByExample(CrmRoleExample example);

    CrmRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CrmRole record, @Param("example") CrmRoleExample example);

    int updateByExample(@Param("record") CrmRole record, @Param("example") CrmRoleExample example);

    int updateByPrimaryKeySelective(CrmRole record);

    int updateByPrimaryKey(CrmRole record);
}