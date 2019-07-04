package com.cetc.weiwen.mapper;



import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cetc.weiwen.entity.EventTypeFunctionType;

@Mapper
public interface EventTypeFunctionTypeMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(EventTypeFunctionType record);

    int insertSelective(EventTypeFunctionType record);


    EventTypeFunctionType selectByPrimaryKey(Integer id);

  
    int updateByPrimaryKeySelective(EventTypeFunctionType record);

    int updateByPrimaryKey(EventTypeFunctionType record);
    
    // 版本id大于eventTypeVId的所有dictionary_eventtype
    List<EventTypeFunctionType> findByVidGreaThan(Integer eventTypeFunctionTypeVId);
}