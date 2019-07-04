package com.cetc.weiwen.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cetc.weiwen.entity.DictionaryEvent;

@Mapper
public interface DictionaryEventMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DictionaryEvent record);

    int insertSelective(DictionaryEvent record);

    DictionaryEvent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DictionaryEvent record);

    int updateByPrimaryKey(DictionaryEvent record);
    
    //版本id大于eventVId的所有dictionary_event
	List<DictionaryEvent> findByVidGreaThan(Integer eventVId);
}