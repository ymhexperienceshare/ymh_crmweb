package com.guigu.crm.mapper;

import com.guigu.crm.model.ActivityQueryVo;
import com.guigu.crm.model.CrmActivity;
import com.guigu.crm.model.CrmActivityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CrmActivityMapper {
    int countByExample(CrmActivityExample example);

    int deleteByExample(CrmActivityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CrmActivity record);

    int insertSelective(CrmActivity record);

    List<CrmActivity> selectByExample(CrmActivityExample example);

    CrmActivity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CrmActivity record, @Param("example") CrmActivityExample example);

    int updateByExample(@Param("record") CrmActivity record, @Param("example") CrmActivityExample example);

    int updateByPrimaryKeySelective(CrmActivity record);

    int updateByPrimaryKey(CrmActivity record);
    
    /*===============By  Ymh===================*/
    List<CrmActivity> selectByCondition(ActivityQueryVo activityQueryVo)throws Exception;
    
    
}