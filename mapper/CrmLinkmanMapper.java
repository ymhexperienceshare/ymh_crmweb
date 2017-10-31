package com.guigu.crm.mapper;

import com.guigu.crm.model.CrmLinkman;
import com.guigu.crm.model.CrmLinkmanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CrmLinkmanMapper {
    int countByExample(CrmLinkmanExample example);

    int deleteByExample(CrmLinkmanExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CrmLinkman record);

    int insertSelective(CrmLinkman record);

    List<CrmLinkman> selectByExample(CrmLinkmanExample example);

    CrmLinkman selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CrmLinkman record, @Param("example") CrmLinkmanExample example);

    int updateByExample(@Param("record") CrmLinkman record, @Param("example") CrmLinkmanExample example);

    int updateByPrimaryKeySelective(CrmLinkman record);

    int updateByPrimaryKey(CrmLinkman record);
}