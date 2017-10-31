package com.guigu.crm.mapper;

import com.guigu.crm.model.CrmRoleRight;
import com.guigu.crm.model.CrmRoleRightExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CrmRoleRightMapper {
    int countByExample(CrmRoleRightExample example);

    int deleteByExample(CrmRoleRightExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CrmRoleRight record);

    int insertSelective(CrmRoleRight record);

    List<CrmRoleRight> selectByExample(CrmRoleRightExample example);

    CrmRoleRight selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CrmRoleRight record, @Param("example") CrmRoleRightExample example);

    int updateByExample(@Param("record") CrmRoleRight record, @Param("example") CrmRoleRightExample example);

    int updateByPrimaryKeySelective(CrmRoleRight record);

    int updateByPrimaryKey(CrmRoleRight record);
}