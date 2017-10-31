package com.guigu.crm.mapper;

import com.guigu.crm.model.CrmPlan;
import com.guigu.crm.model.CrmPlanExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CrmPlanMapper {
    int countByExample(CrmPlanExample example);

    int deleteByExample(CrmPlanExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CrmPlan record);

    int insertSelective(CrmPlan record);

    List<CrmPlan> selectByExample(CrmPlanExample example);

    CrmPlan selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CrmPlan record, @Param("example") CrmPlanExample example);

    int updateByExample(@Param("record") CrmPlan record, @Param("example") CrmPlanExample example);

    int updateByPrimaryKeySelective(CrmPlan record);
    
    int updateByPrimaryKeyWithBLOBs(CrmPlan record);

    int updateByPrimaryKey(CrmPlan record);
}