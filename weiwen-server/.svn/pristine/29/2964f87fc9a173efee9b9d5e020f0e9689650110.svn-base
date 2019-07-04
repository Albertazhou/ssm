package com.cetc.weiwen.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cetc.weiwen.entity.Organization;
import com.cetc.weiwen.entity.Position;

@Mapper
public interface PositionMapper {
 

    int deleteByPrimaryKey(Integer id);

    int insert(Position record);

    int insertSelective(Position record);



    Position selectByPrimaryKey(Integer id);

  
    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKey(Position record);
    
    // 版本id大于positionVId的所有Position
    List<Position> findByVidGreaThan(Integer positionVId);
}