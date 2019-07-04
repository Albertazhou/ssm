package com.cetc.weiwen.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cetc.weiwen.entity.DictionaryEventtype;

@Mapper
public interface DictionaryEventtypeMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(DictionaryEventtype record);

    int insertSelective(DictionaryEventtype record);

    DictionaryEventtype selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DictionaryEventtype record);

    int updateByPrimaryKey(DictionaryEventtype record);
    
    // 版本id大于eventTypeVId的所有dictionary_eventtype
    List<DictionaryEventtype> findByVidGreaThan(Integer eventTypeVId);
}