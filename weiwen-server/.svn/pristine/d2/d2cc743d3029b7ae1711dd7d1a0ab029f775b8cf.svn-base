package com.cetc.weiwen.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cetc.weiwen.entity.EventLevelContact;
import com.cetc.weiwen.entity.Organization;

@Mapper
public interface EventLevelContactMapper {
  
    int deleteByPrimaryKey(Integer id);

    int insert(EventLevelContact record);

    int insertSelective(EventLevelContact record);

   
    EventLevelContact selectByPrimaryKey(Integer id);

 
    int updateByPrimaryKeySelective(EventLevelContact record);

    int updateByPrimaryKey(EventLevelContact record);
    
 // 版本id大于EventLevelContactVId的所有EventLevelContact
    List<EventLevelContact> findByVidGreaThan(Integer eventLevelContactVId);
}