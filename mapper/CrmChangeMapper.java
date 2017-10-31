package com.guigu.crm.mapper;

import com.guigu.crm.model.ChangeQueryVo;
import com.guigu.crm.model.CrmChange;
import com.guigu.crm.model.CrmChangeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CrmChangeMapper {
    int countByExample(CrmChangeExample example);

    int deleteByExample(CrmChangeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CrmChange record);

    int insertSelective(CrmChange record);

    List<CrmChange> selectByExample(CrmChangeExample example);

    CrmChange selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CrmChange record, @Param("example") CrmChangeExample example);

    int updateByExample(@Param("record") CrmChange record, @Param("example") CrmChangeExample example);

    int updateByPrimaryKeySelective(CrmChange record);

    int updateByPrimaryKey(CrmChange record);
    
    public List<CrmChange> findChangeList(ChangeQueryVo changeQueryVo);
}