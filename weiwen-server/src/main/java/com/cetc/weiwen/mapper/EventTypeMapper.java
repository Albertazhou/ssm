package com.cetc.weiwen.mapper;

import com.cetc.weiwen.entity.EventType;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EventTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EventType record);

    int insertSelective(EventType record);


    EventType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EventType record);

    int updateByPrimaryKey(EventType record);
}