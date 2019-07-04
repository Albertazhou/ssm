package com.cetc.weiwen.mapper;

import com.cetc.weiwen.entity.EventRecord;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EventRecordMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(EventRecord record);

    int insertSelective(EventRecord record);

    EventRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EventRecord record);

    int updateByPrimaryKey(EventRecord record);
}