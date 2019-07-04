package com.cetc.weiwen.mapper;

import com.cetc.weiwen.entity.Review;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReviewMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Review record);

    int insertSelective(Review record);

    Review selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Review record);

    int updateByPrimaryKey(Review record);
}