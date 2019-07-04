package com.cetc.weiwen.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cetc.weiwen.entity.FunctionType;

/**
 * @author zhou
 *
 */
@Mapper
public interface FunctionTypeMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(FunctionType record);

    int insertSelective(FunctionType record);

    //获取
    FunctionType selectByPrimaryKey(Integer id);

   
    int updateByPrimaryKeySelective(FunctionType record);

    int updateByPrimaryKey(FunctionType record);
    
    //版本id大于functionTypeVId的所有functionType 
    List<FunctionType> findByVidGreaThan(Integer functionTypeVId);
}