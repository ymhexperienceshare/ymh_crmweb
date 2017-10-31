package com.guigu.crm.mapper;

import com.guigu.crm.model.CrmService;
import com.guigu.crm.model.CrmServiceExample;
import com.guigu.crm.model.ServeQueryVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CrmServiceMapper {
    int countByExample(CrmServiceExample example);

    int deleteByExample(CrmServiceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CrmService record);

    int insertSelective(CrmService record);

    List<CrmService> selectByExample(CrmServiceExample example);

    CrmService selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CrmService record, @Param("example") CrmServiceExample example);

    int updateByExample(@Param("record") CrmService record, @Param("example") CrmServiceExample example);

    int updateByPrimaryKeySelective(CrmService record);

    int updateByPrimaryKey(CrmService record);
    
    public List<CrmService> findHaveCreateService();
    
    public List<CrmService> findHaveDisService();
    
    public List<CrmService> findHaveHandleService();
    
}