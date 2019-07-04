package com.cetc.weiwen.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cetc.weiwen.entity.DictionaryDelete;

@Mapper
public interface DictionaryDeleteMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(DictionaryDelete record);

    DictionaryDelete selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DictionaryDelete record);

    int updateByPrimaryKey(DictionaryDelete record);
    /*查找版本号大于delVId的DictionaryDelete*/
	List<DictionaryDelete> findByVidGreaThan(Integer delVId);
	
	/**
	 * 插入一条删除记录数据
	 * @param record
	 * @return
	 */
    int addDictionaryDelete(DictionaryDelete record);
	
	
}