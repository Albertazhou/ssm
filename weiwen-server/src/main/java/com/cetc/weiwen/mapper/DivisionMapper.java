package com.cetc.weiwen.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cetc.weiwen.entity.Division;

@Mapper
public interface DivisionMapper {
  
    int deleteByPrimaryKey(Integer id);

    int insert(Division record);

    int insertSelective(Division record);

   
    Division selectByPrimaryKey(Integer id);

  
    int updateByPrimaryKeySelective(Division record);

    int updateByPrimaryKey(Division record);
    
    // 版本id大于divisionVId的所有Division
    List<Division> findByVidGreaThan(Integer divisionVId);
}